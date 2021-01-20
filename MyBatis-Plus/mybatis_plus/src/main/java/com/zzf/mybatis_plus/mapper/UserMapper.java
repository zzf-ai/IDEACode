package com.zzf.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzf.mybatis_plus.pojo.User;
import org.springframework.stereotype.Repository;

/*
 *
 *@author:zzf
 *@time:2021-01-19
 *
 */
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
}
