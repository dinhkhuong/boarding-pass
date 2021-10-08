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

        user.setName("NameUpdated");
        user.setEmail("emailUpdated");
        user.setPhoneNumber(987654321);
        user.setGender('F');
        userDao.updateUser(user, 1);
        System.out.println(userDao.getUserById(1));
        //userDao.deleteUserById(1);
    }
}
