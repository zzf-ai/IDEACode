package com.zzf.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zzf.pojo.Student;
import com.zzf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/*
 *
 *@author:zzf
 *@time:2021-01-16
 *
 */
@Component
@Scope("prototype")
public class StudentListener extends AnalysisEventListener<Student> {
    @Autowired
    StudentService studentService;

    ArrayList students = new ArrayList<Student>();
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println(student);
        students.add(student);

        if (students.size()%5==0) {
            studentService.readExcel(students);
            students.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
