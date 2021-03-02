package Entity;

import javax.persistence.*;

@Entity
@Table(name = "position_data")
public class IssPosition {

    @Id
    @GeneratedValue
//    @Column(name = "position_ID")
    private Long id;
    private double latitude;
    private double longitude;


    // GETTER SETTER

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "IssPosition{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
