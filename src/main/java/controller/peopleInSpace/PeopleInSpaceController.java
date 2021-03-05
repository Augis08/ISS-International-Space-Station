package controller.peopleInSpace;

import controller.Controller;
import service.PeopleInSpaceService;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;

public class PeopleInSpaceController implements Controller {
    private final PeopleInSpaceService peopleInSpaceService;
    private final InputReceiver receiver;
    private final OutputProducer output;

    public PeopleInSpaceController(PeopleInSpaceService peopleInSpaceService, InputReceiver receiver, OutputProducer output) {
        this.peopleInSpaceService = peopleInSpaceService;
        this.receiver = receiver;
        this.output = output;
    }

    @Override
    public void run() {
        output.produce("***** PEOPLE IN SPACE *****");
    }
}
