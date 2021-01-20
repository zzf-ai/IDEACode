package com.zzf;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *
 *@author:zzf
 *@time:2021-01-14
 *
 */
public class EasyExcelTest {
    String PATH="D:\\idea��Ŀ\\Study\\poi\\";

    //��ͷ
    /*private  List<List<String>> head(String bigTitle){
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<>();
        head0.add(bigTitle);
        head0.add("�ַ���");
        List<String> head1 = new ArrayList<>();
        head1.add(bigTitle);
        head1.add("����");
        List<String> head2 = new ArrayList<>();
        head2.add(bigTitle);
        head2.add("����");
        head.add(head0);
        head.add(head1);
        head.add(head2);

        return head;
    }*/
    //ͨ����������
    private List<DemoData> data(){
        List<DemoData> list= new ArrayList<>();
        for (int i=0;i<10;i++){
            DemoData data=new DemoData();
            data.setString("�ַ���"+i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    //д��excel
    @Test
    public void simpleWrite(){
        //System.out.println("���");
        String fileName=PATH+"easyTest.xls";

        //write(fileName����ʽ�ࣨʵ���ࣩ)
        //sheet(����)
        //doWrite(����)
        EasyExcel.write(fileName,DemoData.class).
                //head(head("XXX��Ϣ��")).
                sheet("ģ��").
                //registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).//����Ӧ�п�
                doWrite(data());

        //�ظ�����д�ڲ�ͬsheet
        //����ExcelWriter
        /*ExcelWriter excelWriter=EasyExcel.write(fileName,DemoData.class).build();
        for (int i=0;i<3;i++){
            WriteSheet writeSheet=EasyExcel.writerSheet("ģ��"+i).build();
            excelWriter.write(data(),writeSheet);
        }
        //�ر�
        excelWriter.finish();*/

    }
    @Test
    public void simpleRead() {
        // �и�����Ҫ�ĵ� DemoDataListener ���ܱ�spring����Ҫÿ�ζ�ȡexcel��Ҫnew,Ȼ�������õ�spring���Թ��췽������ȥ
        // д��1��
        String fileName = PATH+"easyTest.xls";
        // ���� ��Ҫָ�������ĸ�classȥ����Ȼ���ȡ��һ��sheet �ļ������Զ��ر�
        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        //��ȡȫ��sheet
        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).doReadAll();

        //��ȡĳ����sheet
        //����ExcelReader����
        ExcelReader excelReader=EasyExcel.read(fileName).build();

        //��������sheet��ǩ���������������һ���͵�����
        ReadSheet sheet1=EasyExcel
                .readSheet(0)
                .head(DemoData.class)
                .headRowNumber(2)//�ӵڼ��п�ʼ��
                .registerReadListener(new DemoDataListener())
                .build();

        ReadSheet sheet2=EasyExcel
                .readSheet(2)
                .head(DemoData.class)
                .headRowNumber(2)
                .registerReadListener(new DemoDataListener())
                .build();
        excelReader.read(sheet1,sheet2);
        excelReader.finish();

    }
    @Test
    public void simpleFill() {
        //ģ��
        String template=PATH+"template.xlsx";
        //�����
        String fileName = PATH+"templateTest.xlsx";
        //��������
        FillDate fillDate=new FillDate();
        fillDate.setName("СT");
        fillDate.setNumber(100.91);

        EasyExcel.write(fileName).withTemplate(template).sheet().doFill(fillDate);

    }
    @Test
    public void MoreFill() {
        //ģ��
        String template=PATH+"template2.xlsx";
        //�����
        String fileName = PATH+"templateTest2.xlsx";
        //��������
        List<FillDate> dates=new ArrayList<>();
        for (int i=0;i<10000;i++){
            FillDate fillDate=new FillDate();
            fillDate.setName("СT"+i);
            fillDate.setNumber(100.91+i);
            dates.add(fillDate);
        }

        EasyExcel.write(fileName).withTemplate(template).sheet().doFill(dates);

    }
}
