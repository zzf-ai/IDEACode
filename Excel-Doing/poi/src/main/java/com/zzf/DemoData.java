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
/*//����ͷ����
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 10)
//����ͷ����
@HeadFontStyle(fontHeightInPoints = 20)
//�������ݱ���ɫ
@ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillForegroundColor = 17)
//������������
@ContentFontStyle(fontHeightInPoints = 20)*/
/*//�ϲ���Ԫ������ڶ��е������У���2�е������У��⼸����ϲ�
@OnceAbsoluteMerge(firstRowIndex = 1,lastRowIndex = 2,firstColumnIndex = 1,lastColumnIndex = 2)*/
@ContentRowHeight(30)//�������ݸ߶�
@HeadRowHeight(40)//���ñ���߶�
@ColumnWidth(25)//�����п�
public class DemoData {
    //@ContentLoopMerge(eachRow = 2)//ÿ�����кϲ�һ�Σ����źϲ���Ԫ��
    @ExcelProperty(value = {"XXX��Ϣ��","�ַ�������"},index = 0)//���ñ��⣬˳�򣬴��ͷ
    private String string;

    @DateTimeFormat("yyyy��MM��dd��")
    @ExcelProperty(value = {"XXX��Ϣ��","���ڱ���"},index = 1)
    private Date date;

    @NumberFormat("#.#")
    @ExcelProperty(value = {"XXX��Ϣ��","���ֱ���"},index = 2)
    private Double doubleData;
    /**
     * ��������ֶ�
     */
    @ExcelIgnore
    private String ignore;
}
