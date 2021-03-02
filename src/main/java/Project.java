import Entity.CurrentPosition;
import Entity.IssPosition;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
import utility.JsonUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

;

public class Project {



    public void run() throws Exception {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CurrentPosition.class)
                .addAnnotatedClass(IssPosition.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        String path = "/Users/arnis/Desktop/Coding/JAVA/Git/ISS/iss-now2.json";
        JSONObject jsonObject = (JSONObject) JsonReader.writeJsonSimpleDemo(path);

        CurrentPosition position = new CurrentPosition();


        position = JsonUtils.fromJson(jsonObject.toString(), CurrentPosition.class);
        System.out.println(position);


        t.commit();
    }
}
