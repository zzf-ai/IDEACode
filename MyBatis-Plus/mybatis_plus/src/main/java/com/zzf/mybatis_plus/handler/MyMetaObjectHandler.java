package com.zzf.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 *
 *@author:zzf
 *@time:2021-01-20
 *
 */
@Slf4j
@Component//放进IOC容器
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill....");//插入时填充
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill....");//更新时填充
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
