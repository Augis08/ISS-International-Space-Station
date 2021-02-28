import Entity.IssPosition;
import Entity.CurrentPosition;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class Project {

    public Project() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(IssPosition.class)
                .addAnnotatedClass(CurrentPosition.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
    }

    public void run() {


    }
}
