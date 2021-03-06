package controller.issSpeed;

import controller.Controller;
import entity.IssPosition;
import entity.IssSpeed;
import service.IssSpeedService;
import utilities.HttpRequest;
import utilities.JsonUtils;
import utilities.input.InputReceiver;
import utilities.input.Url;
import utilities.output.OutputProducer;

import java.util.concurrent.TimeUnit;

public class IssSpeedController implements Controller {

    private final IssSpeedService issSpeedService;
    private final InputReceiver receiver;
    private final OutputProducer output;
    private double issSpeed;

    public IssSpeedController(IssSpeedService issSpeedService, InputReceiver receiver, OutputProducer output) {
        this.issSpeedService = issSpeedService;
        this.receiver = receiver;
        this.output = output;
    }

    @Override
    public void run() throws Exception {
        output.produce("***** ISS SPEED *****");
        calculateAndSaveIssSpeed();
        print();
        issSpeedService.findAll().forEach(System.out::println);
    }

    private void calculateAndSaveIssSpeed() throws Exception {
        String jsonIssLocationNow1 = new HttpRequest(new Url().getIssNowUrl()).toString();
        TimeUnit.SECONDS.sleep(5);
        String jsonIssLocationNow2 = new HttpRequest(new Url().getIssNowUrl()).toString();
        IssPosition position1 = JsonUtils.fromJson(jsonIssLocationNow1, IssPosition.class);
        IssPosition position2 = JsonUtils.fromJson(jsonIssLocationNow2, IssPosition.class);

        IssSpeed issSpeedEntity = new IssSpeed(position1, position2);

        this.issSpeed = issSpeedEntity.getIssSpeed();

        issSpeedService.saveIssSpeed(issSpeedEntity);
    }

    private void print() {
        output.produce("ISS speed at this moment is: " + issSpeed + " km/h");
    }
}
