package com.zzf;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *
 *@author:zzf
 *@time:2021-01-14
 *
 */
public class PoiWriteTest {
    String PATH="D:\\idea��Ŀ\\Study\\poi\\";

    @Test
    public void testWrite03() throws IOException {
        //1������һ��������
        Workbook workbook = new HSSFWorkbook();
        //2������һ��������
        Sheet sheet = workbook.createSheet();
        //3������һ���У�1��1��
        Row row = sheet.createRow(0);
        //4������һ����Ԫ��
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("����");

        //����(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("ʱ��");

        //�ڶ���
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("��������");

        //����(2,2)
        Cell cell22 = row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //����excel��
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"03test.xls");

        workbook.write(fileOutputStream);

        //�ر���
        fileOutputStream.close();

        System.out.println("�������");
    }

    @Test
    public void testWrite07() throws IOException {
        //1������һ��������
        Workbook workbook = new XSSFWorkbook();
        //2������һ��������
        Sheet sheet = workbook.createSheet();
        //3������һ���У�1��1��
        Row row = sheet.createRow(0);
        //4������һ����Ԫ��
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("����");

        //����(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("ʱ��");

        //�ڶ���
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("��������");

        //����(2,2)
        Cell cell22 = row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //����excel��
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"07test.xlsx");

        workbook.write(fileOutputStream);

        //�ر���
        fileOutputStream.close();

        System.out.println("�������");
    }

    @Test
    public void testBigDataWrite03() throws IOException {
        //��ʼʱ��
        long begin=System.currentTimeMillis();
        //����������
        Workbook workbook = new HSSFWorkbook();
        //����������
        Sheet sheet = workbook.createSheet();
        for(int rowNum=0;rowNum<65536;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("д�����");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"testBigDataWrite03.xls");
        workbook.write(fileOutputStream);
        workbook.close();
        long end=System.currentTimeMillis();

        System.out.println("��ʱ"+(double)(end-begin)/1000);
    }
    @Test
    public void testBigDataWrite07() throws IOException {
        //��ʼʱ��
        long begin=System.currentTimeMillis();
        //����������
        Workbook workbook = new SXSSFWorkbook();
        //����������
        Sheet sheet = workbook.createSheet();
        for(int rowNum=0;rowNum<100000;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("д�����");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"testBigDataWrite07.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
        //�����ʱ�ļ�
        ((SXSSFWorkbook)workbook).dispose();
        long end=System.currentTimeMillis();

        System.out.println("��ʱ"+(double)(end-begin)/1000);
    }
}
