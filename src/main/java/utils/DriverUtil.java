package utils;

import entity.BoardingPass;
import entity.BoardingPassDetails;
import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "java")
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
}
