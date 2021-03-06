package utilities.input;

public class Url {

    private String issNowUrl;           // "http://api.open-notify.org/iss-now.json";
    private String passTimesUrl;        // "http://api.open-notify.org/iss-pass.json?lat=" + lat + "&lon=" + lon;
    private String peopleInSpaceUrl;    // "http://api.open-notify.org/astros.json";

    public String getIssNowUrl() {
        return "http://api.open-notify.org/iss-now.json";
    }

    public String getIssPassTimesUrl(int lat, int lon) {
        return "http://api.open-notify.org/iss-pass.json?lat=" + lat + "&lon=" + lon;
    }

    public String getPeopleInSpaceUrl() {
        return "http://api.open-notify.org/astros.json";
    }
}
