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
    private List<IssPosition> issPosition;

    protected IssSpeed() {
    }

    public IssSpeed(IssPosition issPosition1, IssPosition issPosition2) {
        this.issPosition = new ArrayList<>();
        issPosition.add(issPosition1);
        issPosition.add(issPosition2);
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

    public List<IssPosition> getIssPosition() {
        return issPosition;
    }

    public void setIssPosition(List<IssPosition> issPosition) {
        this.issPosition = issPosition;
    }

    @Override
    public String toString() {
        return "IssSpeed{" +
                "id= " + id +
                ", issSpeed= " + issSpeed +
                ", issPositions= " + issPosition.toString() +
                '}';
    }
}
