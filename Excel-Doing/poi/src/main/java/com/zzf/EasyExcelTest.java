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
    String PATH="D:\\idea项目\\Study\\poi\\";

    //表头
    /*private  List<List<String>> head(String bigTitle){
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<>();
        head0.add(bigTitle);
        head0.add("字符串");
        List<String> head1 = new ArrayList<>();
        head1.add(bigTitle);
        head1.add("日期");
        List<String> head2 = new ArrayList<>();
        head2.add(bigTitle);
        head2.add("数字");
        head.add(head0);
        head.add(head1);
        head.add(head2);

        return head;
    }*/
    //通用数据生成
    private List<DemoData> data(){
        List<DemoData> list= new ArrayList<>();
        for (int i=0;i<10;i++){
            DemoData data=new DemoData();
            data.setString("字符串"+i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    //写入excel
    @Test
    public void simpleWrite(){
        //System.out.println("妈的");
        String fileName=PATH+"easyTest.xls";

        //write(fileName，格式类（实体类）)
        //sheet(表名)
        //doWrite(数据)
        EasyExcel.write(fileName,DemoData.class).
                //head(head("XXX信息表")).
                sheet("模板").
                //registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).//自适应列宽
                doWrite(data());

        //重复内容写在不同sheet
        //创建ExcelWriter
        /*ExcelWriter excelWriter=EasyExcel.write(fileName,DemoData.class).build();
        for (int i=0;i<3;i++){
            WriteSheet writeSheet=EasyExcel.writerSheet("模板"+i).build();
            excelWriter.write(data(),writeSheet);
        }
        //关闭
        excelWriter.finish();*/

    }
    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = PATH+"easyTest.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        //读取全部sheet
        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).doReadAll();

        //读取某几个sheet
        //构建ExcelReader对象
        ExcelReader excelReader=EasyExcel.read(fileName).build();

        //构建具体sheet标签对象，例如这里读第一个和第三个
        ReadSheet sheet1=EasyExcel
                .readSheet(0)
                .head(DemoData.class)
                .headRowNumber(2)//从第几行开始读
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
        //模板
        String template=PATH+"template.xlsx";
        //填充后的
        String fileName = PATH+"templateTest.xlsx";
        //构建数据
        FillDate fillDate=new FillDate();
        fillDate.setName("小T");
        fillDate.setNumber(100.91);

        EasyExcel.write(fileName).withTemplate(template).sheet().doFill(fillDate);

    }
    @Test
    public void MoreFill() {
        //模板
        String template=PATH+"template2.xlsx";
        //填充后的
        String fileName = PATH+"templateTest2.xlsx";
        //构建数据
        List<FillDate> dates=new ArrayList<>();
        for (int i=0;i<10000;i++){
            FillDate fillDate=new FillDate();
            fillDate.setName("小T"+i);
            fillDate.setNumber(100.91+i);
            dates.add(fillDate);
        }

        EasyExcel.write(fileName).withTemplate(template).sheet().doFill(dates);

    }
}
