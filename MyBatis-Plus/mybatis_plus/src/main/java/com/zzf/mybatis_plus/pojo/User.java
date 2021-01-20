package com.zzf.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 *
 *@author:zzf
 *@time:2021-01-19
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type=IdType.AUTO)//可设置不同的主键策略，默认是雪花算法
    private Integer id;
    private String name;
    private Integer age;
    private String email;

    @Version//乐观锁（每次更新先查询version值，在此基础上比较和加1，如果多线程可能会出现更新失败）
    private Integer version;

    @TableLogic//逻辑删除
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)//自动填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//自动填充
    private Date updateTime;
}
