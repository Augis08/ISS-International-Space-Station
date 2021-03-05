package controller.issPassTimes;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.Controller;
import entity.IssPassTimes;
import service.IssPassTimesService;
import utilities.HttpRequest;
import utilities.JsonUtils;
import utilities.input.InputReceiver;
import utilities.input.Url;
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
    public void run() throws JsonProcessingException {
        output.produce("***** ISS PASS TIMES *****");
        printInstructions();
        Integer latitude = receiveLatitude();
        Integer longitude = receiveLongitude();
        String urlForIssPassTimes = new Url().getPassTimesUrl(latitude, longitude);
        String jsonForIssPassTimes = new HttpRequest(urlForIssPassTimes).toString();
        IssPassTimes issPassTimes = JsonUtils.fromJson(jsonForIssPassTimes, IssPassTimes.class);
        output.produce("ISS pass times at location with latitude " + latitude + " and longitude " + longitude + ": ");
        issPassTimes.getResponse().forEach(System.out::println);
        issPassTimesService.saveIssPassTimes(issPassTimes);
    }

    private void printInstructions() {
        output.produce("To get upcoming ISS runs insert locations latitude and longitude: ");
    }

    private boolean latitudeValidation(Integer lat) {
        return lat >= -70 && lat <= 70;
    }

    private boolean longitudeValidation(Integer lon) {
        return lon >= -180 && lon <= 180;
    }

    private Integer receiveLatitude() {
        output.produce("Insert latitude: ");
        Integer lat = Integer.parseInt(receiver.receiveLine());
        if (!latitudeValidation(lat)) {
            output.produce("Wrong insert. Latitude valid range is {-70...70}");
            receiveLatitude();
        }
        return lat;
    }

    private Integer receiveLongitude() {
        output.produce("Insert longitude: ");
        Integer lon = Integer.parseInt(receiver.receiveLine());
        if (!longitudeValidation(lon)) {
            output.produce("Wrong insert. Longitude valid range is {-180...180}");
            receiveLongitude();
        }
        return lon;
    }
}
