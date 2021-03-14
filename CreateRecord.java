package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CreateRecord {

    private static void createExcelFile(XSSFWorkbook book, String name, String address) {
        try (FileOutputStream record = new FileOutputStream(new File(address + "//" + name + ".xls"))) {
            book.write(record);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static HashMap<String, String> rename(HashMap<String, String> map, HashMap<String, String> rename) {
        for (String field: rename.keySet()) {
            String value = map.get(field);
            String renameField = rename.get(field);
            map.remove(field);
            map.put(renameField, value);
        }
        return map;
    }

    static XSSFWorkbook about(Object object, String nameObject, String address) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        HashMap<String, String> map = new HashMap<>();
        map = ParserObject.objectToMap(object);
        book = OutputToExcel.objectInMapToWorkbook(nameObject, map);
        CreateRecord.createExcelFile(book, nameObject, address);
        return book;
    }

    static XSSFWorkbook about(Object object, String address) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        book = CreateRecord.about(object, "UnknowObject", address);
        return book;
    }

    static XSSFWorkbook about(Object object, String nameObject, String address, HashMap<String, String> rename) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        HashMap<String, String> map = new HashMap<>();
        map = ParserObject.objectToMap(object);

        map = CreateRecord.rename(map, rename);

        book = OutputToExcel.objectInMapToWorkbook(nameObject, map);
        CreateRecord.createExcelFile(book, nameObject, address);
        return book;
    }

    static XSSFWorkbook about(Object object, String address, HashMap<String, String> rename) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        HashMap<String, String> map = new HashMap<>();
        map = ParserObject.objectToMap(object);

        map = CreateRecord.rename(map, rename);

        book = OutputToExcel.objectInMapToWorkbook("Unknow", map);
        CreateRecord.createExcelFile(book, "Unknow", address);
        return book;
    }

    static XSSFWorkbook about(Collection<Object> objects, String address) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        ArrayList<HashMap<String, String>> data = ParserObject.collectionToMaps(objects);

        String name = ParserObject.getClass(objects.iterator().next());
        ArrayList<String> fields = ParserObject.objectOnFields(objects.iterator().next());
        book = OutputToExcel.objectsInMapsToWorkbook(name, fields, data);

        CreateRecord.createExcelFile(book, name, address);
        return book;
    }

    static XSSFWorkbook about(Collection<Object> objects, String address, HashMap<String , String> rename) throws IllegalAccessException {
        XSSFWorkbook book = new XSSFWorkbook();
        ArrayList<HashMap<String, String>> data = ParserObject.collectionToMaps(objects);
        for (HashMap<String, String> map: data) {
            map = CreateRecord.rename(map, rename);
        }
        String name = ParserObject.getClass(objects.iterator().next());
        ArrayList<String> fields = ParserObject.objectOnFields(objects.iterator().next());
        book = OutputToExcel.objectsInMapsToWorkbook(name, fields, data);

        CreateRecord.createExcelFile(book, name, address);
        return book;
    }


}
