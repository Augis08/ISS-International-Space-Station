import controller.entry.EntryController;
import controller.issPassTimes.IssPassTimesController;
import controller.issSpeed.IssSpeedController;
import controller.peopleInSpace.PeopleInSpaceController;
import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repositories.issPassTimes.IssPassTimesRepository;
import repositories.issSpeed.IssSpeedRepository;
import repositories.peopleInSpace.PeopleInSpaceRepository;
import service.IssPassTimesService;
import service.IssSpeedService;
import service.PeopleInSpaceService;
import utilities.input.DefaultInputReceiver;
import utilities.input.InputReceiver;
import utilities.output.DefaultOutputProducer;
import utilities.output.OutputProducer;

import javax.persistence.EntityManager;

public class Project {

        public static final String HIBERNATE_CONFIGURATION = "hibernate.cfg.xml";

    public Project() throws Exception {
        constructEntryController(entityManager()).run();
    }

    private EntryController constructEntryController (EntityManager entityManager){
        InputReceiver receiver = new DefaultInputReceiver();
        OutputProducer output = new DefaultOutputProducer();
        IssSpeedService issSpeedService = new IssSpeedService(new IssSpeedRepository(entityManager));
        IssPassTimesService issPassTimesService = new IssPassTimesService(new IssPassTimesRepository(entityManager));
        PeopleInSpaceService peopleInSpaceService = new PeopleInSpaceService(new PeopleInSpaceRepository(entityManager));

        IssSpeedController issSpeedController = new IssSpeedController(issSpeedService, receiver, output);
        IssPassTimesController issPassTimesController = new IssPassTimesController(issPassTimesService, receiver, output);
        PeopleInSpaceController peopleInSpaceController = new PeopleInSpaceController(peopleInSpaceService, output);

        return new EntryController(issPassTimesController, issSpeedController, peopleInSpaceController, receiver, output);

    }

    private EntityManager entityManager(){
        SessionFactory sessionFactory = new Configuration()
                .configure(HIBERNATE_CONFIGURATION)
                .addAnnotatedClass(IssPosition.class)
                .addAnnotatedClass(IssSpeed.class)
                .addAnnotatedClass(PeopleInSpace.class)
                .addAnnotatedClass(People.class)
                .addAnnotatedClass(IssPassTimes.class)
                .addAnnotatedClass(IssPassTimesRequest.class)
                .addAnnotatedClass(IssPassTimesResponse.class)
                .buildSessionFactory();

        return sessionFactory.createEntityManager();
    }

}
