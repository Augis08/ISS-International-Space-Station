package service;

import entity.IssPosition;

public class SpeedCalculator {

    private final IssPosition issPosition1;
    private final IssPosition issPosition2;
    private final double issSpeed;
    public SpeedCalculator(IssPosition issPosition1, IssPosition issPosition2) {
        this.issPosition1 = issPosition1;
        this.issPosition2 = issPosition2;
        this.issSpeed = calculateDistanceInKm() / calculateTime() * 3600;
    }
    private double calculateDistanceInKm() {
        double lat1 = issPosition1.getIss_position().get("latitude");
        double long1 = issPosition1.getIss_position().get("longitude");
        double lat2 = issPosition2.getIss_position().get("latitude");
        double long2 = issPosition2.getIss_position().get("longitude");
        double distance = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return distance / 1000;
    }
    private double calculateTime (){
        return Math.abs(issPosition1.getTimestamp() - issPosition2.getTimestamp());
    }
    public double getIssSpeed() {
        return issSpeed;
    }
}
