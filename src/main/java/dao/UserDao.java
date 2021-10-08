package dao;

import entity.User;

public interface UserDao {

    public void writeUser();

    public User getUserById();

    public void deleteUserById();

    public void updateUser();
}
