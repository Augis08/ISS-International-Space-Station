package entity;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "issPositions")
public class IssPosition {

    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private HashMap<String, Double> iss_position;
    private long timestamp;
    private String message;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "issSpeed_id")
    private IssSpeed issSpeed;

    // CONSTRUCTOR

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public HashMap<String, Double> getIss_position() {
        return iss_position;
    }

    public void setIss_position(HashMap<String, Double> iss_position) {
        this.iss_position = iss_position;
    }

    // METHODS

    @Override
    public String toString() {
        return "{" +
                "Position: " +  iss_position +
                ", TIMESTAMP: " + timestamp +
                '}';
    }
}
