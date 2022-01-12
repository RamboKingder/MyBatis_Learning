package com.lxl.test;

import com.lxl.dao.UserMapper;
import com.lxl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DynamicSQLTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 模拟一下条件
        User user = new User();
        // user.setId(1);
        //
        // user.setUsername("zhangsan");
        user.setPassword("123");

        // List<User> users = mapper.findByCondition(user);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);
        List<User> users = mapper.findByIds(ids);
        System.out.println(users);
    }



}
