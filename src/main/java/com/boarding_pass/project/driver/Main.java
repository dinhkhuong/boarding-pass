package com.boarding_pass.project.driver;

import com.boarding_pass.project.dao.UserDao;
import com.boarding_pass.project.dao.UserDaoImpl;
import com.boarding_pass.project.entity.User;
import com.boarding_pass.project.utils.DriverUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DriverUtil.class);
        User user = context.getBean(User.class);

        UserDao userDao = context.getBean(UserDaoImpl.class);

        userDao.addUser(user);

        System.out.println(userDao.getUserById(1));

        User user2 = userDao.getUserById(1);
        user2.setName("NameUpdated");
        user2.setEmail("emailUpdated");
        user2.setPhoneNumber(987654321);
        user2.setGender('F');
        userDao.updateUser(user2, 1);
        System.out.println(userDao.getUserById(1));
        //userDao.deleteUserById(1);
    }
}
