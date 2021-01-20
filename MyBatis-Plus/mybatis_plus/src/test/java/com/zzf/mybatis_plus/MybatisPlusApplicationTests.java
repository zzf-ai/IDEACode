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

        //��ѯȫ���û�������ΪWrapper����������������Ϊnull
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    //���Բ���
    @Test
    void testInsert(){
        User user=new User();
        user.setName("aaaaaBO");
        user.setAge(18);
        user.setEmail("1q555@qq.com");
        userMapper.insert(user);
    }

    //���Ը���
    @Test
    void testUpdate(){
        User user=new User();
        //ͨ�������Զ�ƴװ��̬sql
        user.setId(8);
        user.setName("HHHa");
        user.setAge(22);
        int i=userMapper.updateById(user);
        System.out.println(i);
    }

    //�����ֹ���(���̣߳�
    @Test
    public void testOptimisticLocker(){
        //��ѯ�û���Ϣ
        User user=userMapper.selectById(8L);
        //�޸�
        user.setName("Kkkkg");
        user.setEmail("171789@qq.com");
        userMapper.updateById(user);
    }

    //�����ֹ���(���̣߳�
    @Test
    void testOptimisticLocker2(){
        //�߳�1
        User user=userMapper.selectById(8L);
        user.setName("zzf");
        user.setEmail("2418092@qq.com");

        //ģ������һ�߳�ִ���˲�Ӳ���
        User user2=userMapper.selectById(8L);
        user2.setName("zzzf");
        user2.setEmail("2929929@qq.com");
        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    //���Բ�ѯById
    @Test
    void testSelectById(){
        User user =userMapper.selectById(8L);
        System.out.println(user);
    }

    //����������ѯ
    @Test
    void testSelectByBatchId(){
        List<User> users=userMapper.selectBatchIds(Arrays.asList(6,7,8));
        users.forEach(System.out::println);
    }

    //���԰�������ѯBy map
    @Test
    void testSelectByMap(){
        HashMap<String, Object> map = new HashMap();
        map.put("name","zzzf");
        map.put("age",22);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //���Է�ҳ��ѯ
    @Test
    void testPage(){
        //����1����ǰҳ��ҳ���С
        //����2��ҳ���С
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page,null);
    }

    //����ɾ��
    @Test
    void testDeleteById(){
        userMapper.deleteById(1);
    }

    //ͨ��id����ɾ��
    @Test
    void testDeleteBatchById(){
        userMapper.deleteBatchIds(Arrays.asList(2,3));
    }

    //ͨ��Mapɾ��
    @Test
    void testDeleteByMap(){
        HashMap<String, Object> map=new HashMap<>();
        map.put("name","JoLin");
        userMapper.deleteByMap(map);
    }

    //�����߼�ɾ��
    @Test
    void tsetLogicDelete(){
        userMapper.deleteById(5);
    }
}
