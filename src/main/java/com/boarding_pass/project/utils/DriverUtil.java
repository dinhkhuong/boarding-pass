package com.boarding_pass.project.utils;


import com.boarding_pass.project.entity.BoardingPass;
import com.boarding_pass.project.entity.BoardingPassDetails;
import com.boarding_pass.project.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.boarding_pass.project")
public class DriverUtil {

    @Bean
    public Session getSession() throws HibernateException {
        SessionFactory sessionFactory = new Configuration()
                .configure("Hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(BoardingPass.class)
                .addAnnotatedClass(BoardingPassDetails.class)
                .buildSessionFactory();

        return sessionFactory.openSession();
    }

    @Bean
    public User getUser(){
        return new User();
    }

    /*@Bean
    public User getUser(){
        return new User("A-Team", "ateam@gmail.com", 1234567890, 'M', 35);
    }*/

    /*@Bean
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }*/

    @Bean
    public BoardingPass getBoardingPass(){
        return new BoardingPass(1);
    }

    @Bean
    public BoardingPassDetails getBoardingPassDetails() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("h:m a");

        return new BoardingPassDetails("California", "North Carolina", formatter.parse("1:45 AM"), formatter.parse("12:0 PM"));
    }


}
