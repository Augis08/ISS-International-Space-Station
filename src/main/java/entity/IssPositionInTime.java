package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "positionsInTime")
public class IssPositionInTime {

    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("iss_position")
    private IssPosition issPosition;

    private long timestamp;
    private String message;


    // CONSTRUCTOR
    public IssPositionInTime() {}

    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IssPosition getIssPosition() {
        return issPosition;
    }

    public void setIssPosition(IssPosition issPosition) {
        this.issPosition = issPosition;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    // METHODS

    @Override
    public String toString() {
        return "CurrentPosition{" +
                "ID = " + id +
                ", POSITION =" + issPosition +
                ", TIMESTAMP =" + timestamp +
                '}';
    }
}
