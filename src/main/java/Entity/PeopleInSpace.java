package Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "peopleInSpace")
public class PeopleInSpace{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @JsonProperty("number")
    private int numberOfPeople;

    @OneToMany(cascade = CascadeType.ALL)
    private List<People> people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "PeopleInSpace{" +
                "id=" + id +
                ", numberOfPeople=" + numberOfPeople +
                ", people=" + people.stream().map(People::getName).collect(Collectors.toList()) +
                '}';
    }
}
