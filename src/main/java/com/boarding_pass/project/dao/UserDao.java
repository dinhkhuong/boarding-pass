package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;

public interface UserDao {

    public void writeUser();

    public User getUserById();

    public void deleteUserById();

    public void updateUser();
}
