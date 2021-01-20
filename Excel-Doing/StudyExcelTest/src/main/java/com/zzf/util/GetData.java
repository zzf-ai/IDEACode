package com.zzf.util;

import com.zzf.pojo.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *
 *@author:zzf
 *@time:2021-01-16
 *
 */
public class GetData {
    //通用数据生成
    public static List<Student> data(){
        List<Student> list= new ArrayList<>();
        for (int i=0;i<10;i++){
            Student data=new Student();
            data.setString("字符串"+i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
