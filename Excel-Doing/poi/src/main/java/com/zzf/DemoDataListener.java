package com.zzf;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *@author:zzf
 *@time:2021-01-14
 *
 */
// �и�����Ҫ�ĵ� DemoDataListener ���ܱ�spring����Ҫÿ�ζ�ȡexcel��Ҫnew,Ȼ�������õ�spring���Թ��췽������ȥ
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    /**
     * ÿ��5���洢���ݿ⣬ʵ��ʹ���п���3000����Ȼ������list �������ڴ����
     */
    private static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<DemoData>();

    private DemoDAO demoDAO;
    public DemoDataListener() {
        // ������demo���������newһ����ʵ��ʹ���������spring,��ʹ��������вι��캯��
        demoDAO = new DemoDAO();
    }
    public DemoDataListener(DemoDAO demoDAO) {
        this.demoDAO = demoDAO;
    }

    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        //System.out.println(data.getDate());
        System.out.println(JSON.toJSONString(data));
        list.add(data);
        // �ﵽBATCH_COUNT�ˣ���Ҫȥ�洢һ�����ݿ⣬��ֹ���ݼ������������ڴ棬����OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // �洢������� list
            list.clear();
        }
    }
    /**
     * �������ݽ�������� ����������
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("�����ɹ�");
        // ����ҲҪ�������ݣ�ȷ���������������Ҳ�洢�����ݿ�
        saveData();
        LOGGER.info("�������ݽ�����ɣ�");
    }
    /**
     * ���ϴ洢���ݿ�
     */
    private void saveData() {
        LOGGER.info("{}�����ݣ���ʼ�洢���ݿ⣡", list.size());
        demoDAO.save(list);
        LOGGER.info("�洢���ݿ�ɹ���");
    }
}
