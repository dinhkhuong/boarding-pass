package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private Session session;

    public UserDaoImpl() {
    }

    @Override
    @Transactional
    public void addUser(User user){
        session.save(user);
    }

    @Override
    @Transactional
    public User getUserById(int id){
        User user = session.get(User.class, id );
        if(user == null){
            throw new RuntimeException("There is no user with the id - " + id);
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(int id){
        User user = getUserById(id);
        if(user != null){
            session.delete(user);
        }
        System.out.println("Confirmation of deleted user with id - " + id);
    }

    @Override
    @Transactional
    public void updateUser(User user, int id){
        User u = getUserById(id);
        if(u == null){
            throw new RuntimeException("There is no user with the id - " + id);
        }
        u = user;
        session.saveOrUpdate(u);
        System.out.println("User " + u.getName() + " has been updated");
    }
}
