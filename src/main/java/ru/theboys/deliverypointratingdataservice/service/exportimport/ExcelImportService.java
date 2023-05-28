package ru.theboys.deliverypointratingdataservice.service.exportimport;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    messageRepository.save(message);
                }

            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(EXCEL_IMPORT_ERROR + e.getMessage());
        }
    }
}
