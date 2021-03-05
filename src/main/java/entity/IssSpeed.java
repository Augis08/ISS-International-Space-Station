package entity;

import service.SpeedCalculator;

import javax.persistence.*;

@Entity
@Table (name = "issSpeed")
public class IssSpeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final double issSpeed;

    @OneToOne(mappedBy = "issSpeed")
    @PrimaryKeyJoinColumn
    private final IssPosition issPosition1;

    @OneToOne(mappedBy = "issSpeed")
    @PrimaryKeyJoinColumn
    private final IssPosition issPosition2;


    public IssSpeed(IssPosition issPosition1, IssPosition issPosition2) {
        this.issPosition1 = issPosition1;
        this.issPosition2 = issPosition2;
        this.issSpeed = new SpeedCalculator(issPosition1, issPosition2).getIssSpeed();
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
                "id= " + id +
                ", issSpeed= " + issSpeed +
                ", Position1= " + issPosition1 +
                ", Position2= " + issPosition2 +
                '}';
    }
}
