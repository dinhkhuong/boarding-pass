package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;

public interface UserDao {

    public void addUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);

    public void updateUser(User user, int id);
}
