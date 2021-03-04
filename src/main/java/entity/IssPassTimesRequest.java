package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "issPassTimesRequests")
public class IssPassTimesRequest {
    @Id
    @GeneratedValue
    private Long Id;

    private double altitude;
    private int datetime;
    private int passes;
    private double latitude;
    private double longitude;

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

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
        return "{" +
                "altitude=" + altitude +
                ", datetime=" + datetime +
                ", passes=" + passes +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    // {"request":{"altitude":100,"datetime":1614797020,"passes":5,"latitude":65.0,"longitude":65.0},

}
