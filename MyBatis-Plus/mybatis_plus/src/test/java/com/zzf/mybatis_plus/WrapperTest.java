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
        //��ѯname��Ϊ�յ��û����������䲻Ϊ�գ�������ڵ���12
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",21);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    //��ѯһ�����
    @Test
    void test2(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("name","JOBO");
        User user=userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    //��ѯ�������
    @Test
    void test3(){
        //��ѯ������20-30��֮����û�
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.between("age",20,30);//����
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //ģ����ѯ
    @Test
    void test4(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.notLike("name","e")//������e
                .likeRight("email","t");//��t��ͷ����t%
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    //�Ӳ�ѯ
    @Test
    void test5(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id>3");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    //�����ѯ
    @Test
    void test6(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
