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
        IssPassTimes issPassTimes = getIssPassTimes();
        issPassTimesService.saveIssPassTimes(issPassTimes);
    }

    private IssPassTimes getIssPassTimes() throws JsonProcessingException {
        double latitude = receiveLatitude();
        double longitude = receiveLongitude();
        String urlForIssPassTimes = new Url().getIssPassTimesUrl(latitude, longitude);
        String jsonForIssPassTimes = new HttpRequest(urlForIssPassTimes).toString();
        IssPassTimes issPassTimes = JsonUtils.fromJson(jsonForIssPassTimes, IssPassTimes.class);
        output.produce("ISS pass times at location with latitude " + latitude + " and longitude " + longitude + ": ");
        issPassTimes.getResponse().forEach(System.out::println);
        return issPassTimes;
    }

    private void printInstructions() {
        output.produce("To get upcoming ISS runs insert locations latitude and longitude: ");
    }

    private boolean latitudeValidation(double lat) {
        return lat >= -70 && lat <= 70 && lat != 0;
    }

    private boolean longitudeValidation(double lon) {
        return lon >= -180 && lon <= 180 && lon != 0;
    }

    private double receiveLatitude() {
        output.produce("Insert latitude: ");
        double lat = 0;
        try {
            lat = Double.parseDouble(receiver.receiveLine().replace(",","."));
        } catch (NumberFormatException e){
            output.produce("Wrong insert. Latitude must be a number");
            lat = receiveLatitude();
        }
        if (!latitudeValidation(lat)) {
            output.produce("Wrong insert. Latitude valid range is {-70...70}");
            lat = receiveLatitude();
        }
        return lat;
    }

    private double receiveLongitude() {
        output.produce("Insert longitude: ");
        double lon = 0;
        try {
            lon = Double.parseDouble(receiver.receiveLine().replace(",","."));
        } catch (NumberFormatException e) {
            output.produce("Wrong insert. Latitude must be a number");
            lon = receiveLongitude();
        }
        if (!longitudeValidation(lon)) {
            output.produce("Wrong insert. Longitude valid range is {-180...180}");
            lon = receiveLongitude();
        }
        return lon;
    }
}
