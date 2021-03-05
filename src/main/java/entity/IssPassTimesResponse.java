package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IssPassTimesResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private int duration;
    private int risetime;

    public Long getId() {
        return Id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRisetime() {
        return risetime;
    }

    public void setRisetime(int risetime) {
        this.risetime = risetime;
    }

    @Override
    public String toString() {
        return "{" +
                "duration: " + duration +
                ", risetime: " + risetime +
                "}";
    }
}
