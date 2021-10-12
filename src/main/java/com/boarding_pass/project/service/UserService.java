package com.boarding_pass.project.service;

import com.boarding_pass.project.entity.User;

import java.util.List;

public interface UserService {

    public List<User> listUsers();

    public void addUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);

    public void updateUser(User user, int id);
}
