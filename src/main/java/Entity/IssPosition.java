package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "issPositions")
public class IssPosition {

    @Id
    @GeneratedValue
    private int id;

    private double latitude;
    private double longitude;


    // GETTER SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Entity.IssPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
