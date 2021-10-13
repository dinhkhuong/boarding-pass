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

import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Input in = new Input();

        ApplicationContext context = new AnnotationConfigApplicationContext(DriverUtil.class);
        User user = context.getBean(User.class);

        user.setName(in.getName());
        user.setEmail(in.getEmail());
        user.setPhoneNumber(in.getPhoneNumber());
        user.setGender(in.getGender());
        user.setAge(in.getAge());

        UserDao userDao = context.getBean(UserDaoImpl.class);

        userDao.addUser(user);

        Require req = new Require(in);

        //Calendar arrive = req.eTA();

        System.out.println("You have purchased a boarding pass to " + in.getDestination() +
                " and the departure at "+req.getTime().getTime());
        System.out.println("Your price is: $" + req.priceCal());
        System.out.println("Your ticket number is: " + req.getBoardNumber());
        System.out.println("The estimated arrival time for this journey is: "+ req.eTA().getTime());

        req.putInFile();

        System.out.println(userDao.getUserById(1));
    }
}
