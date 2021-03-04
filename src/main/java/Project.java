import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utilities.HttpRequest;
import utilities.JsonUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Project {

    public void run() throws Exception {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(IssPositionInTime.class)
                .addAnnotatedClass(IssPosition.class)
                .addAnnotatedClass(IssSpeed.class)
                .addAnnotatedClass(PeopleInSpace.class)
                .addAnnotatedClass(People.class)
                .addAnnotatedClass(IssPassTimes.class)
                .addAnnotatedClass(IssPassTimesRequest.class)
                .addAnnotatedClass(IssPassTimesResponse.class)
                .buildSessionFactory();

        EntityManager em = sessionFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();

        String issNowUrl = "http://api.open-notify.org/iss-now.json";
        String jsonIssLocationNow1 = new HttpRequest(issNowUrl).toString();
        TimeUnit.SECONDS.sleep(5);
        String jsonIssLocationNow2 = new HttpRequest(issNowUrl).toString();

        int lat = 60;
        int lon = 60;
        String passTimesUrl = "http://api.open-notify.org/iss-pass.json?lat=" + lat + "&lon=" + lon;
        String jsonIssPass = new HttpRequest(passTimesUrl).toString();

        String peopleInSpaceUrl = "http://api.open-notify.org/astros.json";
        String jsonPeopleInSpace = new HttpRequest(peopleInSpaceUrl).toString();

        IssPositionInTime position1 = JsonUtils.fromJson(jsonIssLocationNow1, IssPositionInTime.class);
        IssPositionInTime position2 = JsonUtils.fromJson(jsonIssLocationNow2, IssPositionInTime.class);
        PeopleInSpace peopleInSpace = JsonUtils.fromJson(jsonPeopleInSpace, PeopleInSpace.class);
        IssPassTimes issPassTimes = JsonUtils.fromJson(jsonIssPass, IssPassTimes.class);

        IssSpeed issSpeed = new IssSpeed(position1, position2);

        em.persist(position1);
        em.persist(position2);
        em.persist(issSpeed);
        em.persist(peopleInSpace);
        em.persist(issPassTimes);

        t.commit();

        System.out.println("---------------");

        List<IssPositionInTime> cp = em.createQuery("FROM IssPositionInTime", IssPositionInTime.class).getResultList();
        cp.forEach(System.out::println);

        System.out.println("---------------");

        List<IssSpeed> issSpeeds = em.createQuery("FROM IssSpeed", IssSpeed.class).getResultList();
        issSpeeds.forEach(System.out::println);

        System.out.println("---------------");

        List<PeopleInSpace> ps = em.createQuery("FROM PeopleInSpace", PeopleInSpace.class).getResultList();
        ps.forEach(System.out::println);

        System.out.println("---------------");

        List<IssPassTimes> ipt = em.createQuery("FROM IssPassTimes", IssPassTimes.class).getResultList();
        ipt.forEach(System.out::println);
    }
}
