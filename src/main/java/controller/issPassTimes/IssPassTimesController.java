package controller.issPassTimes;

import controller.Controller;
import service.IssPassTimesService;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;

public class IssPassTimesController implements Controller {
    private final IssPassTimesService issPassTimesService;
    private final InputReceiver receiver;
    private final OutputProducer output;

    public IssPassTimesController(IssPassTimesService issPassTimesService, InputReceiver receiver, OutputProducer output) {
        this.issPassTimesService = issPassTimesService;
        this.receiver = receiver;
        this.output = output;
    }

    @Override
    public void run() {
        output.produce("***** ISS PASS TIMES *****");
    }
}
