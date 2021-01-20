package com.zzf.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzf.mybatis_plus.mapper.UserMapper;
import com.zzf.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        //查询全部用户，参数为Wrapper条件构建器，先设为null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    //测试插入
    @Test
    void testInsert(){
        User user=new User();
        user.setName("aaaaaBO");
        user.setAge(18);
        user.setEmail("1q555@qq.com");
        userMapper.insert(user);
    }

    //测试更新
    @Test
    void testUpdate(){
        User user=new User();
        //通过条件自动拼装动态sql
        user.setId(8);
        user.setName("HHHa");
        user.setAge(22);
        int i=userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁(单线程）
    @Test
    public void testOptimisticLocker(){
        //查询用户信息
        User user=userMapper.selectById(8L);
        //修改
        user.setName("Kkkkg");
        user.setEmail("171789@qq.com");
        userMapper.updateById(user);
    }

    //测试乐观锁(多线程）
    @Test
    void testOptimisticLocker2(){
        //线程1
        User user=userMapper.selectById(8L);
        user.setName("zzf");
        user.setEmail("2418092@qq.com");

        //模拟另外一线程执行了插队操作
        User user2=userMapper.selectById(8L);
        user2.setName("zzzf");
        user2.setEmail("2929929@qq.com");
        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    //测试查询ById
    @Test
    void testSelectById(){
        User user =userMapper.selectById(8L);
        System.out.println(user);
    }

    //测试批量查询
    @Test
    void testSelectByBatchId(){
        List<User> users=userMapper.selectBatchIds(Arrays.asList(6,7,8));
        users.forEach(System.out::println);
    }

    //测试按条件查询By map
    @Test
    void testSelectByMap(){
        HashMap<String, Object> map = new HashMap();
        map.put("name","zzzf");
        map.put("age",22);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //测试分页查询
    @Test
    void testPage(){
        //参数1：当前页，页面大小
        //参数2：页面大小
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page,null);
    }

    //测试删除
    @Test
    void testDeleteById(){
        userMapper.deleteById(1);
    }

    //通过id批量删除
    @Test
    void testDeleteBatchById(){
        userMapper.deleteBatchIds(Arrays.asList(2,3));
    }

    //通过Map删除
    @Test
    void testDeleteByMap(){
        HashMap<String, Object> map=new HashMap<>();
        map.put("name","JoLin");
        userMapper.deleteByMap(map);
    }

    //测试逻辑删除
    @Test
    void tsetLogicDelete(){
        userMapper.deleteById(5);
    }
}
