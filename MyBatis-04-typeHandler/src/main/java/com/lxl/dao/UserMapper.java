package com.lxl.dao;

import com.lxl.domain.User;

import java.util.List;

public interface UserMapper {
    public void save(User user);

    public User findById(int id);
}
