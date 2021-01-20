package com.zzf.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.zzf.listener.StudentListener;
import com.zzf.pojo.Student;
import com.zzf.util.GetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/*
 *
 *@author:zzf
 *@time:2021-01-16
 *
 */
@Controller
@RequestMapping("student")
public class StudentController {
    String PATH="D:\\idea项目\\Study\\StudyExcelTest\\";
    @Autowired
    StudentListener studentListener;

    @RequestMapping("read")
    @ResponseBody
    public String readExcel(/*MultipartFile uploadExcel*/){
        String fileName = PATH+"easyTest.xls";
        EasyExcel.read(/*uploadExcel.getInputStream()*/fileName, Student.class,studentListener).sheet().doRead();
        return "success";
    }

    @RequestMapping("write")
    @ResponseBody
    public void writeExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application//vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //防止中文乱码
        String fileName= URLEncoder.encode("测试","UTF-8");
        response.setHeader("Content-Disposition","attachment;filename*=UTF-8''"+fileName+".xlsx");

        ServletOutputStream outputStream = response.getOutputStream();

        //write(fileName，格式类（实体类）)
        //sheet(表名)
        //doWrite(数据)
        EasyExcel.write(outputStream,Student.class).
                //head(head("XXX信息表")).
                sheet("模板").
                registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).//自适应列宽
                        doWrite(GetData.data());
    }
}
