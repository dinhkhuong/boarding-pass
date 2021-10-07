package dio;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class userDio {
    public void setup() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        session.save(new User("Khuong"));
        session.save(new User("Matthew"));

        session.getTransaction().commit();

        session.close();
    }
}
