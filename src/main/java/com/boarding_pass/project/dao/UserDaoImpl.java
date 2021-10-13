package com.boarding_pass.project.dao;

import com.boarding_pass.project.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//stereotype for repo, enables componentScan and allows spring to handle exception translation
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private Session session;

    public UserDaoImpl() {
    }

    //letting spring start and stop CRUD operations with @Transactional
    //method names are self-explanatory
    @Override
    @Transactional
    public List<User> listUsers(){
        session.beginTransaction();
        List<User> list = (List<User>) session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return list;
    }

    @Override
    @Transactional
    public void addUser(User user){
        session.beginTransaction();
        session.saveOrUpdate("User", user);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public User getUserById(int id){
        session.beginTransaction();
        User user = session.get(User.class, id );
        session.getTransaction().commit();
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
            session.getTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
        System.out.println("Confirmation of deleted user with id - " + id);
    }

    @Override
    public void updateUser(User user, int id){
        User u = getUserById(id);
        if(u == null){
            throw new RuntimeException("There is no user with the id - " + id);
        }
        u = user;
        session.beginTransaction();
        session.saveOrUpdate(u);
        session.getTransaction().commit();
        System.out.println("User " + u.getName() + " has been updated");
    }
}
