package com.zzf.service.impl;

import com.zzf.pojo.Student;
import com.zzf.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 *@author:zzf
 *@time:2021-01-16
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void readExcel(List<Student> students) {
        for (Student student : students) {
            System.out.println("student="+student);
        }
    }
}
