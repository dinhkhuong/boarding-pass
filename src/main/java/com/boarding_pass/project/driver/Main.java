package com.boarding_pass.project.driver;

import com.boarding_pass.project.dao.BoardingPassDaoImpl;
import com.boarding_pass.project.dao.UserDao;
import com.boarding_pass.project.dao.UserDaoImpl;
import com.boarding_pass.project.dao.BoardingPassDao;
import com.boarding_pass.project.dao.BoardingPassDaoImpl;
import com.boarding_pass.project.entity.BoardingPass;
import com.boarding_pass.project.entity.BoardingPassDetails;
import com.boarding_pass.project.entity.User;
import com.boarding_pass.project.utils.DriverUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        String name = "Tan";
        String email = "tan@bla.com";
        int phoneNo = 52535342;
        int age = 32;
        char gender = 'M';
        ApplicationContext context = new AnnotationConfigApplicationContext(DriverUtil.class);

        User user = context.getBean(User.class);
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNo);
        user.setGender(gender);
        user.setAge(age);

        UserDao userDao = context.getBean(UserDaoImpl.class);

        userDao.addUser(user);


        /*BoardingPass boardingPass = context.getBean(BoardingPass.class);
        boardingPass.setBoardingPassNumber(6573);
        BoardingPassDao boardingPassDao = context.getBean(BoardingPassDao.class);*/


        System.out.println(userDao.getUserById(1));


    }
}
