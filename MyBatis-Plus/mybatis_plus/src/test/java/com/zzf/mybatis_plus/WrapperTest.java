package com.zzf.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzf.mybatis_plus.mapper.UserMapper;
import com.zzf.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/*
 *
 *@author:zzf
 *@time:2021-01-20
 *
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads(){
        //查询name不为空的用户，并且邮箱不为空，年龄大于等于12
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",21);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    //查询一个结果
    @Test
    void test2(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("name","JOBO");
        User user=userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    //查询结果数量
    @Test
    void test3(){
        //查询年龄在20-30岁之间的用户
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.between("age",20,30);//区间
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //模糊查询
    @Test
    void test4(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.notLike("name","e")//不包含e
                .likeRight("email","t");//以t开头，即t%
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    //子查询
    @Test
    void test5(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id>3");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    //排序查询
    @Test
    void test6(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
