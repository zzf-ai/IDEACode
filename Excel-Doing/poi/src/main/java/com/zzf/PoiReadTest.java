package com.zzf;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/*
 *
 *@author:zzf
 *@time:2021-01-14
 *
 */
/*public class PoiReadTest {

    String PATH="D:\\idea��Ŀ\\Study\\poi\\";

    @Test
    public void testRead03() throws IOException {

        FileInputStream fileInputStream=new FileInputStream(PATH+"03test.xls");

        //����������
        Workbook workbook=new HSSFWorkbook (fileInputStream);

        //��ȡ������
        Sheet sheet=workbook.getSheetAt(0);
        //�õ���
        Row row = sheet.getRow(1);
        //�õ���
        Cell cell = row.getCell(1);

        System.out.println(cell.getStringCellValue());
        //����
        fileInputStream.close();
    }

    @Test
    public void testRead07() throws IOException {

        FileInputStream fileInputStream=new FileInputStream(PATH+"07test.xlsx");

        //����������
        Workbook workbook=new XSSFWorkbook(fileInputStream);

        //��ȡ������
        Sheet sheet=workbook.getSheetAt(0);
        //�õ���
        Row row = sheet.getRow(1);
        //�õ���
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());
        //����
        fileInputStream.close();
    }

    @Test
    public void testReadType03() throws IOException {
        FileInputStream fileInputStream=new FileInputStream(PATH+"03test.xls");

        //����������
        Workbook workbook=new HSSFWorkbook(fileInputStream);

        //��ȡ���
        Sheet sheet=workbook.getSheetAt(0);

        //��ȡ��������
        Row rowTitle = sheet.getRow(0);
        if(rowTitle!=null){
            int cellCount=rowTitle.getPhysicalNumberOfCells();
            for (int cellNum=0;cellNum<cellCount;cellNum++){
                Cell cell=rowTitle.getCell(cellNum);
                if(cell!=null){
                    String cellValue=cell.getStringCellValue();
                    System.out.print(cellValue+"|");
                }
            }
        }

        System.out.println();
        //��ȡ��������
        int rowCount=sheet.getPhysicalNumberOfRows();
        for (int rowNum=1;rowNum<rowCount;rowNum++){
            Row rowData = sheet.getRow(rowNum);
            if(rowData!=null){
                int cellCount=rowTitle.getPhysicalNumberOfCells();
                for (int cellNum=0;cellNum<cellCount;cellNum++){
                    Cell cell=rowData.getCell(cellNum);
                    if(cell!=null){
                        CellType cellType=cell.getCellType();
                        String cellValue="";
                        switch (cellType){
                            case STRING:
                                System.out.println("��string��");
                                cellValue=cell.getStringCellValue();
                                break;
                            case BOOLEAN:
                                System.out.println("��boolean��");
                                cellValue=String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK://��
                                System.out.println("��blank��");
                                break;
                            case NUMERIC:
                                System.out.println("��numeric��");
                                if(HSSFDateUtil.isCellDateFormatted(cell)){
                                    System.out.println("�����ڡ�");
                                    Date date=cell.getDateCellValue();
                                    cellValue=new DateTime(date).toString("yyyy-MM-dd");
                                }else {
                                    //��ֹ���ֹ���
                                    System.out.println("��ת�ַ�����");
                                    cell.setCellType(cellType.STRING);
                                    cellValue=cell.toString();
                                }
                                break;
                            case ERROR:
                                System.out.println("�����ʹ���");
                                break;

                        }
                        System.out.println(cellValue);
                    }
                }
            }
        }
        //����
        fileInputStream.close();
    }
}*/
