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

    public static void main(String[] args)throws NullPointerException {

        Input in = new Input();

        Require req = new Require(
                in.getName(),in.getEmail(),in.getDestination(),
                in.getPhoneNumber(),in.getGender(),in.getAge(),
                in.getMonth(),in.getDay(),in.getHour());
        Calendar arrive = req.eTA(in.getDestination());
        System.out.println(arrive.getTime());
        System.out.println(arrive.get(Calendar.MONTH));
        System.out.println(arrive.get(Calendar.DAY_OF_MONTH));
        System.out.println(arrive.get(Calendar.HOUR_OF_DAY));
        System.out.println(arrive.get(Calendar.MINUTE));
    }
}
