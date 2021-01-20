package com.zzf;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.*;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.util.Date;

/*
 *
 *@author:zzf
 *@time:2021-01-14
 *
 */
@Data
/*//设置头背景
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 10)
//设置头字体
@HeadFontStyle(fontHeightInPoints = 20)
//设置内容背景色
@ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 17)
//设置内容字体
@ContentFontStyle(fontHeightInPoints = 20)*/
/*//合并单元格，例如第二行到第三行，第2列到第三列，这几个格合并
@OnceAbsoluteMerge(firstRowIndex = 1,lastRowIndex = 2,firstColumnIndex = 1,lastColumnIndex = 2)*/
@ContentRowHeight(30)//设置内容高度
@HeadRowHeight(40)//设置标题高度
@ColumnWidth(25)//设置列宽
public class DemoData {
    //@ContentLoopMerge(eachRow = 2)//每隔两行合并一次，竖着合并单元格
    @ExcelProperty(value = {"XXX信息表","字符串标题"},index = 0)//设置标题，顺序，大表头
    private String string;

    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty(value = {"XXX信息表","日期标题"},index = 1)
    private Date date;

    @NumberFormat("#.#")
    @ExcelProperty(value = {"XXX信息表","数字标题"},index = 2)
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
