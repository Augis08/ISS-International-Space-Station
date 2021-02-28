public class IssPosition {

    private double latitude;
    private double longitude;


    // GETTER SETTER

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "IssPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
