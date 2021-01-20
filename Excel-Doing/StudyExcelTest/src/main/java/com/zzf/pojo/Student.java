package com.zzf.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.util.Date;

/*
 *
 *@author:zzf
 *@time:2021-01-16
 *
 */
@Data
public class Student {
    @ExcelProperty(value = {"XXX信息表","字符串标题"},index = 0)//设置标题，顺序，大表头
    private String string;

    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty(value = {"XXX信息表","日期标题"},index = 1)
    private Date date;

    @NumberFormat("#.#")
    @ExcelProperty(value = {"XXX信息表","数字标题"},index = 2)
    private Double doubleData;

}
