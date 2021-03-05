package controller.peopleInSpace;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.Controller;
import entity.PeopleInSpace;
import service.PeopleInSpaceService;
import utilities.HttpRequest;
import utilities.JsonUtils;
import utilities.input.Url;
import utilities.output.OutputProducer;

public class PeopleInSpaceController implements Controller {
    private final PeopleInSpaceService peopleInSpaceService;
    private final OutputProducer output;

    public PeopleInSpaceController(PeopleInSpaceService peopleInSpaceService, OutputProducer output) {
        this.peopleInSpaceService = peopleInSpaceService;
        this.output = output;
    }

    @Override
    public void run() throws JsonProcessingException {
        output.produce("***** PEOPLE IN SPACE *****");
        PeopleInSpace peopleInSpace = JsonUtils.fromJson(new HttpRequest(new Url().getPeopleInSpaceUrl()).toString(), PeopleInSpace.class);
        peopleInSpaceService.savePeopleInSpace(peopleInSpace);
        output.produce("Number of people in space within the ISS: " + peopleInSpace.getNumberOfPeople());
    }
}
