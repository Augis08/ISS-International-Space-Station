import Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
import utility.JsonUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class Project {

    public void run() throws Exception {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(IssPositionInTime.class)
                .addAnnotatedClass(IssPosition.class)
                .addAnnotatedClass(IssSpeed.class)
                .addAnnotatedClass(PeopleInSpace.class)
                .addAnnotatedClass(People.class)
                .buildSessionFactory();

        EntityManager em = sessionFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();
        String path1 = "/Users/arnis/Desktop/Coding/JAVA/Git/ISS/iss-now1.json";
        String path2 = "/Users/arnis/Desktop/Coding/JAVA/Git/ISS/iss-now2.json";
        String path3 = "/Users/arnis/Desktop/Coding/JAVA/Git/ISS/astros.json";
      //  String path4 = "/Users/arnis/Desktop/Coding/JAVA/Git/ISS/iss-pass.json";

        JSONObject jsonObject1 = (JSONObject) JsonReader.writeJsonSimpleDemo(path1);
        JSONObject jsonObject2 = (JSONObject) JsonReader.writeJsonSimpleDemo(path2);
        JSONObject jsonObject3 = (JSONObject) JsonReader.writeJsonSimpleDemo(path3);
        // JSONObject jsonObject4 = (JSONObject) JsonReader.writeJsonSimpleDemo(path4);

        IssPositionInTime position1 = JsonUtils.fromJson(jsonObject1.toString(), IssPositionInTime.class);
        IssPositionInTime position2 = JsonUtils.fromJson(jsonObject2.toString(), IssPositionInTime.class);
        PeopleInSpace peopleInSpace = JsonUtils.fromJson(jsonObject3.toString(), PeopleInSpace.class);

        IssSpeed issSpeed = new IssSpeed(position1, position2);

        em.persist(position1);
        em.persist(position2);
        em.persist(issSpeed);
        em.persist(peopleInSpace);

        t.commit();

//        List<CurrentPosition> cp = em.createQuery("FROM CurrentPosition", CurrentPosition.class).getResultList();
//        cp.forEach(System.out::println);
//
//        System.out.println("---------------");
//
//        List<IssSpeed> issSpeeds = em.createQuery("FROM IssSpeed", IssSpeed.class).getResultList();
//        issSpeeds.forEach(System.out::println);
//
//        System.out.println("---------------");
//
//        List<PeopleInSpace> ps = em.createQuery("FROM PeopleInSpace", PeopleInSpace.class).getResultList();
//        ps.forEach(System.out::println);
    }
}
