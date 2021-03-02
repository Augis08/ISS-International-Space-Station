package Entity;

import javax.persistence.*;

@Entity
@Table (name = "issSpeed")
public class IssSpeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final double issSpeed;

    @OneToOne
    private final CurrentPosition currentPosition1;

    @OneToOne
    private final CurrentPosition currentPosition2;


    public IssSpeed(CurrentPosition currentPosition1, CurrentPosition currentPosition2) {
        this.currentPosition1 = currentPosition1;
        this.currentPosition2 = currentPosition2;
        this.issSpeed = calculateDistanceInKm()
                / calculateTime()
                * 3600;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private double calculateDistanceInKm () {
        double lat1 = currentPosition1.getIssPosition().getLatitude();
        double long1 = currentPosition1.getIssPosition().getLongitude();
        double lat2 = currentPosition2.getIssPosition().getLatitude();
        double long2 = currentPosition2.getIssPosition().getLongitude();

        double distance = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return distance/1000;
    }

    private double calculateTime (){
        return Math.abs(currentPosition1.getTimestamp() - currentPosition2.getTimestamp());
    }

    public double getIssSpeed() {
        return issSpeed;
    }

    @Override
    public String toString() {
        return "IssSpeed{" +
                "id=" + id +
                ", issSpeed=" + issSpeed +
                ", currentPosition1=" + currentPosition1 +
                ", currentPosition2=" + currentPosition2 +
                '}';
    }
}
