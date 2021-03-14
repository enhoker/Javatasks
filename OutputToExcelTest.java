package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputToExcelTest {

    @Test
    public void objectsInMapsToWorkbookTest() throws IllegalAccessException {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "Funny faces");
        map1.put("arter", "Asinastra");
        map1.put("size", "2");
        map1.put("ended", "true");
        list.add(map1);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name", "Dragon");
        map2.put("arter", "Bart");
        map2.put("size", "8");
        map2.put("ended", "true");
        list.add(map1);
        ArrayList<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("arter");
        fields.add("size");
        fields.add("ended");
        XSSFWorkbook actbook = OutputToExcel.objectsInMapsToWorkbook("sheet", fields, list);

        XSSFWorkbook exbook = new XSSFWorkbook();
        Sheet sheet = exbook.createSheet("sheet");
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        Row row2 = sheet.createRow(2);
        Cell cell00 = row0.createCell(0);
        cell00.setCellValue("name");
        Cell cell01 = row0.createCell(1);
        cell01.setCellValue("arter");
        Cell cell02 = row0.createCell(2);
        cell02.setCellValue("size");
        Cell cell03 = row0.createCell(3);
        cell03.setCellValue("ended");
        Cell cell10 = row0.createCell(0);
        cell10.setCellValue("Funny faces");
        Cell cell11 = row0.createCell(1);
        cell11.setCellValue("Asinastra");
        Cell cell12 = row0.createCell(2);
        cell12.setCellValue("2");
        Cell cell13 = row0.createCell(3);
        cell13.setCellValue("true");
        Cell cell20 = row0.createCell(0);
        cell20.setCellValue("Dragon");
        Cell cell21 = row0.createCell(1);
        cell11.setCellValue("Bart");
        Cell cell22 = row0.createCell(2);
        cell12.setCellValue("8");
        Cell cell23 = row0.createCell(3);
        cell13.setCellValue("true");

        Assert.assertEquals(exbook, actbook);
    }

    @Test
    public void objectInMapToWorkbookTest() throws  IllegalAccessException {
        XSSFWorkbook exbook = new XSSFWorkbook();
        Sheet sheet = exbook.createSheet("sheet");
        Row row0 = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        Row row2 = sheet.createRow(2);
        Cell cell00 = row0.createCell(0);
        cell00.setCellValue("name");
        Cell cell01 = row0.createCell(1);
        cell01.setCellValue("arter");
        Cell cell02 = row0.createCell(2);
        cell02.setCellValue("size");
        Cell cell03 = row0.createCell(3);
        cell03.setCellValue("ended");
        Cell cell10 = row0.createCell(0);
        cell10.setCellValue("Funny faces");
        Cell cell11 = row0.createCell(1);
        cell11.setCellValue("Asinastra");
        Cell cell12 = row0.createCell(2);
        cell12.setCellValue("2");
        Cell cell13 = row0.createCell(3);
        cell13.setCellValue("true");

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Funny faces");
        map.put("arter", "Asinastra");
        map.put("size", "2");
        map.put("ended", "true");
        XSSFWorkbook actbook = OutputToExcel.objectInMapToWorkbook("sheet", map);

        Assert.assertEquals(exbook, actbook);

    }



}



























