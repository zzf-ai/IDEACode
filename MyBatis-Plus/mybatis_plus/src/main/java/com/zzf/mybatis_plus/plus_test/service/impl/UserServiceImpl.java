package com.zzf.mybatis_plus.plus_test.service.impl;

import com.zzf.mybatis_plus.plus_test.entity.User;
import com.zzf.mybatis_plus.plus_test.mapper.UserMapper;
import com.zzf.mybatis_plus.plus_test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzf
 * @since 2021-01-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
