package com.boarding_pass.project.driver;

import com.boarding_pass.project.dao.UserDao;
import com.boarding_pass.project.dao.UserDaoImpl;
import com.boarding_pass.project.entity.BoardingPass;
import com.boarding_pass.project.entity.BoardingPassDetails;
import com.boarding_pass.project.entity.User;
import com.boarding_pass.project.service.UserService;
import com.boarding_pass.project.service.UserServiceImpl;
import com.boarding_pass.project.utils.DriverUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

public class Main {


    //testing userDao operations
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DriverUtil.class);
        UserService userService = context.getBean(UserServiceImpl.class);
        /*
        User user = context.getBean(User.class);
        BoardingPass boardingPass = context.getBean(BoardingPass.class);
        BoardingPassDetails boardingPassDetails = context.getBean(BoardingPassDetails.class);



        boardingPass.setBoardingPassDetails(boardingPassDetails);
        user.setBoardingPass(boardingPass);

        userService.addUser(user);

         */

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Atlanta", 10);
        Input input = new Input(map);
        System.out.println(userService.getUserById(4));

    }
}
