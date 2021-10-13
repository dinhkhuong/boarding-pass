package com.boarding_pass.project.driver;

import com.boarding_pass.project.entity.User;
import com.boarding_pass.project.service.UserService;
import com.boarding_pass.project.service.UserServiceImpl;
import com.boarding_pass.project.utils.DriverUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Collaborators Khoung, Matthew, James

public class Main {

    //testing userDao operations
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(DriverUtil.class);

        UserService userService = context.getBean(UserServiceImpl.class);

        User user2 = userService.getUserById(7);
        System.out.println(user2);
        user2.setName("James");
        user2.setEmail("james@james.com");
        user2.setPhoneNumber(54765735);
        user2.setGender('M');

        //Serves as examples to use the database
        userService.updateUser(user2, 7);

//        userService.addUser(user2);

//        userService.listUsers();
//
//        System.out.println(userService.getUserById(7));
//
//        userService.deleteUserById(7);
//
//        System.out.println(userService.listUsers());

    }
}
