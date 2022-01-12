package com.lxl.test;

import com.lxl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testDelete() throws IOException {

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        int row = sqlSession.delete("userMapper.delete", 8);
        System.out.println(row);

        // MyBatis中执行增删改操作，必须提交事务才会生效
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {

        User user = new User();
        user.setId(8);
        user.setUsername("龙哥");
        user.setPassword("666666666");

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        int row = sqlSession.update("userMapper.update", user);
        System.out.println(row);

        // MyBatis中执行增删改操作，必须提交事务才会生效
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {

        User user = new User();
        user.setId(0);
        user.setUsername("龙哥");
        user.setPassword("666");

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        int row = sqlSession.insert("userMapper.save", user);
        System.out.println(row);

        // MyBatis中执行增删改操作，必须提交事务才会生效
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testQueryAll() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        for (User user : userList) {
            System.out.println(user);
        }
        // System.out.println(userList);
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testQueryOne() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作 参数：namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 1);
        // 打印数据
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }
}
