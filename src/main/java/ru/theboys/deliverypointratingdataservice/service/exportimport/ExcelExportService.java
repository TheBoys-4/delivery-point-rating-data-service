package ru.theboys.deliverypointratingdataservice.service.exportimport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.constants.ExcelExportConstants;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ExcelExportService implements ExportService {
    private static final String EXCEL_EXPORT_ERROR = "Failed to create Excel document: ";
    private static final String FAILED_TO_ACCESS_FIELD = "Failed to access field: ";
    private static final String SHEET_NAME = "Export";

    private final MessageRepository messageRepository;

    @Autowired
    public ExcelExportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<byte[]> export() {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet(SHEET_NAME);
            this.createDocument(sheet);
            workbook.write(byteArrayOutputStream);
            return toResponseEntity(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(EXCEL_EXPORT_ERROR + e.getMessage());
        }
    }

    private void createDocument(XSSFSheet sheet) {
        this.setHeaders(sheet);
        this.setData(sheet);
    }

    private void setHeaders(XSSFSheet sheet) {
        Row row = sheet.createRow(0);
        Field[] headerConstants = ExcelExportConstants.class.getFields();

        try {
            for (int i = 0; i < headerConstants.length; i++) {
                Cell header = row.createCell(i);
                header.setCellValue((String) headerConstants[i].get(this));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(FAILED_TO_ACCESS_FIELD + e.getMessage());
        }
    }

    private void setData(XSSFSheet sheet) {
        List<Message> messages = messageRepository.findAll();

        int messageNumber = 1;

        for (Message message : messages) {
            Row row = sheet.createRow(messageNumber);

            Cell numberCell = row.createCell(0);
            numberCell.setCellValue(messageNumber);

            Cell dateCell = row.createCell(1);
            dateCell.setCellValue(message.getDateTime());

            Cell sourceCell = row.createCell(2);
            sourceCell.setCellValue(message.getMessageSource().name());

            Cell administrativeDistrictCell = row.createCell(3);
            administrativeDistrictCell.setCellValue(message.getLocation().getAdministrativeDistrict());

            Cell districtCell = row.createCell(4);
            districtCell.setCellValue(message.getLocation().getDistrict());

            Cell addressCell = row.createCell(5);
            addressCell.setCellValue(message.getLocation().getAddress());

            //Cell entranceCell = row.createCell(6);
            //entranceCell.setCellValue(message.getLocation().getEntrance());

            Cell vendorCell = row.createCell(7);
            vendorCell.setCellValue(message.getVendor().getName());

            Cell clientId = row.createCell(8);
            clientId.setCellValue(message.getClient().getId());

            Cell messageStatus = row.createCell(9);
            messageStatus.setCellValue(message.getScore());

            Cell messageMainType = row.createCell(10);
            messageMainType.setCellValue(message.getMessageType().getMessageMainType().name());

            Cell messageType = row.createCell(11);
            messageType.setCellValue(message.getMessageType().getName());

            Cell messageText = row.createCell(12);
            messageText.setCellValue(message.getText());

//            Cell action = row.createCell(13);
//            action.setCellValue(message.getAction());

            messageNumber = messageNumber + 1;
        }
    }

    private ResponseEntity<byte[]> toResponseEntity(byte[] bytes) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.xlsx");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(bytes.length)
                .body(bytes);
    }
}
