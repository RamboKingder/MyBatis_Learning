package com.lxl.service;


import com.lxl.dao.UserMapper;
import com.lxl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceDemo {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 这里用getMapper方法传入Dao层的接口让他去给我们生成接口实现类的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // List<User> users = mapper.findAll();
        // for (User user : users) {
        //     System.out.println(user);
        // }

        User user = mapper.findById(1);
        System.out.println(user);

    }
}
