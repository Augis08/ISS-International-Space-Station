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
    private final IssPositionInTime issPositionInTime1;

    @OneToOne
    private final IssPositionInTime issPositionInTime2;


    public IssSpeed(IssPositionInTime issPositionInTime1, IssPositionInTime issPositionInTime2) {
        this.issPositionInTime1 = issPositionInTime1;
        this.issPositionInTime2 = issPositionInTime2;
        this.issSpeed = new SpeedCalculator(issPositionInTime1,issPositionInTime2).getIssSpeed();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getIssSpeed() {
        return issSpeed;
    }

    @Override
    public String toString() {
        return "IssSpeed{" +
                "id=" + id +
                ", issSpeed=" + issSpeed +
                ", currentPosition1=" + issPositionInTime1 +
                ", currentPosition2=" + issPositionInTime2 +
                '}';
    }
}
