package entity;

public class SpeedCalculator {

    private final IssPositionInTime issPositionInTime1;
    private final IssPositionInTime issPositionInTime2;
    private final double issSpeed;
    public SpeedCalculator(IssPositionInTime issPositionInTime1, IssPositionInTime issPositionInTime2) {
        this.issPositionInTime1 = issPositionInTime1;
        this.issPositionInTime2 = issPositionInTime2;
        this.issSpeed = calculateDistanceInKm() / calculateTime() * 3600;
    }
    private double calculateDistanceInKm() {
        double lat1 = issPositionInTime1.getIssPosition().getLatitude();
        double long1 = issPositionInTime1.getIssPosition().getLongitude();
        double lat2 = issPositionInTime2.getIssPosition().getLatitude();
        double long2 = issPositionInTime2.getIssPosition().getLongitude();
        double distance = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return distance / 1000;
    }
    private double calculateTime (){
        return Math.abs(issPositionInTime1.getTimestamp() - issPositionInTime2.getTimestamp());
    }
    public double getIssSpeed() {
        return issSpeed;
    }
}
