package ru.theboys.deliverypointratingdataservice.service.exportimport;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.dataProcessing.DataProcessing;
import ru.theboys.deliverypointratingdataservice.entity.Client;
import ru.theboys.deliverypointratingdataservice.entity.Location;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.Vendor;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;
import ru.theboys.deliverypointratingdataservice.enums.MessageSource;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;
import ru.theboys.deliverypointratingdataservice.utils.MessageUtil;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Locale;

@Service
public class ExcelImportService implements ImportService {
    private static final String EXCEL_IMPORT_ERROR = "Failed to parse Excel document: ";

    private final MessageRepository messageRepository;

    @Autowired
    public ExcelImportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void importFile(MultipartFile multipartFile) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);

            File file = new File(multipartFile.getName());
            OutputStream os = new FileOutputStream(file);
            os.write(multipartFile.getBytes());
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() != 0) {
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Message message = new Message();
                    message.setMessageSource(MessageSource.IMPORT);

                    setMockData(message);

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();

                        switch (columnIndex) {
                            case 0:
                                message.setText(cell.getStringCellValue());
                                break;
                            case 2:
                                message.setScore((int) cell.getNumericCellValue());
                                break;
                        }
                    }
                    DataProcessing.ClassificationByText(message);

                    messageRepository.save(message);
                }

            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(EXCEL_IMPORT_ERROR + e.getMessage());
        }
    }

    private void setMockData(Message message) {
        message.setDateTime(Date.valueOf(LocalDate.now()));
        message.setClient(new Client("mockName", "mockNumber", "mockEmail", "mockSex", 22));
        message.setVendor(new Vendor("mockVendor"));
        message.setLocation(new Location("1", "2", "3", "4", LocationType.CITY));
    }
}
