package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Record implements Report{
    public XSSFWorkbook workbook;

    void Record() {
        workbook = new XSSFWorkbook();
    }

    @Override
    public byte[] asBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            workbook.write(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public void writeTo(OutputStream os) {
        try {
            os.write(asBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
