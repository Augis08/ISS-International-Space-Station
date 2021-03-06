package entity;

import service.SpeedCalculator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "issSpeed")
public class IssSpeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double issSpeed;

    @OneToMany(mappedBy = "issSpeed")
    @PrimaryKeyJoinColumn
    private List<IssPosition> issPositions;


    public IssSpeed() {
    }

    public IssSpeed(IssPosition issPosition1, IssPosition issPosition2) {
        this.issPositions = new ArrayList<>();
        issPositions.add(issPosition1);
        issPositions.add(issPosition2);
        this.issSpeed = new SpeedCalculator(issPosition1, issPosition2).getIssSpeed();
    }

    public List<IssPosition> getIssPositions() {
        return issPositions;
    }

    public void setIssPositions(List<IssPosition> issPositions) {
        this.issPositions = issPositions;
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
                ", issPositions=" + issPositions +
                '}';
    }
}

