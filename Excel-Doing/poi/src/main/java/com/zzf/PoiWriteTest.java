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
    String PATH="D:\\idea项目\\Study\\poi\\";

    @Test
    public void testWrite03() throws IOException {
        //1、创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //2、创建一个工作表
        Sheet sheet = workbook.createSheet();
        //3、创建一个行（1，1）
        Row row = sheet.createRow(0);
        //4、创建一个单元格
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("内容");

        //创建(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("时间");

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("测试内容");

        //创建(2,2)
        Cell cell22 = row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //生成excel表
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"03test.xls");

        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("生成完成");
    }

    @Test
    public void testWrite07() throws IOException {
        //1、创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //2、创建一个工作表
        Sheet sheet = workbook.createSheet();
        //3、创建一个行（1，1）
        Row row = sheet.createRow(0);
        //4、创建一个单元格
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("内容");

        //创建(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("时间");

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("测试内容");

        //创建(2,2)
        Cell cell22 = row2.createCell(1);
        String time=new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //生成excel表
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"07test.xlsx");

        workbook.write(fileOutputStream);

        //关闭流
        fileOutputStream.close();

        System.out.println("生成完成");
    }

    @Test
    public void testBigDataWrite03() throws IOException {
        //开始时间
        long begin=System.currentTimeMillis();
        //创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet();
        for(int rowNum=0;rowNum<65536;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("写入完成");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"testBigDataWrite03.xls");
        workbook.write(fileOutputStream);
        workbook.close();
        long end=System.currentTimeMillis();

        System.out.println("用时"+(double)(end-begin)/1000);
    }
    @Test
    public void testBigDataWrite07() throws IOException {
        //开始时间
        long begin=System.currentTimeMillis();
        //创建工作簿
        Workbook workbook = new SXSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet();
        for(int rowNum=0;rowNum<100000;rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum=0;cellNum<10;cellNum++){
                Cell cell=row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("写入完成");
        FileOutputStream fileOutputStream=new FileOutputStream(PATH+"testBigDataWrite07.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
        //清除临时文件
        ((SXSSFWorkbook)workbook).dispose();
        long end=System.currentTimeMillis();

        System.out.println("用时"+(double)(end-begin)/1000);
    }
}
