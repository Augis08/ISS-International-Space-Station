package utilities.input;

import utilities.HttpRequest;

public class JsonString {
    String jsonForIssPassTimes;
    String jsonForIssSpeed;
    String jsonForPeopleInSpace;

    public JsonString(int lat, int lon) {
        String url = new Url().getIssPassTimesUrl(lat,lon);
        this.jsonForIssPassTimes = new HttpRequest(url).toString();
    }

    public JsonString() {
        String url = new Url().getIssNowUrl();
        this.jsonForIssSpeed = new HttpRequest(url).toString();
    }

    public String getJsonForIssPassTimes() {
        return jsonForIssPassTimes;
    }

    public String getJsonForIssSpeed() {
        return jsonForIssSpeed;
    }

    public String getJsonForPeopleInSpace() {
        return jsonForPeopleInSpace;
    }
}
