package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Collection;
import java.util.HashMap;

public class OutputToExcel {

    static XSSFWorkbook objectsInMapsToWorkbook (String nameObject, Collection<String> fields, Collection<HashMap<String, String>> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(nameObject);
        Row rowName = sheet.createRow(0);

        // заполняем верхнюю строчку
        {
            int columnNum = 0;
            for (String columnName : fields) {
                Cell nameField = rowName.createCell(columnNum);
                nameField.setCellValue(columnName);
                columnNum = columnNum + 1;
            }
        }

        { //заполняем остальные строки
            int rowNum = 0;
            for (HashMap<String, String> map : data) {
                rowNum = rowNum + 1;
                int columnNum = 0;
                Row rowValue = sheet.createRow(rowNum);
                for (String columnName : fields) {
                    Cell nameField = rowName.createCell(columnNum);
                    nameField.setCellValue(columnName);
                    Cell valueField = rowValue.createCell(columnNum);
                    valueField.setCellValue(map.get(columnName));
                    columnNum = columnNum + 1;
                }

            }
        }

        return workbook;
    }

    static XSSFWorkbook objectInMapToWorkbook (String nameObject, HashMap<String, String> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(nameObject);
        Row rowName = sheet.createRow(0);
        Row rowValue = sheet.createRow(1);

        int columnNum = 0;
        for (String columnName : data.keySet()) {
            Cell nameField = rowName.createCell(columnNum);
            nameField.setCellValue(columnName);
            Cell columValue = rowValue.createCell(columnNum);
            columValue.setCellValue(data.get(columnName));
            columnNum = columnNum + 1;
        }

        return workbook;
    }





}
