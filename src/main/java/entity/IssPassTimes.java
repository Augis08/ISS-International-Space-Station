package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "issPassTimes")
public class IssPassTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne(cascade = CascadeType.ALL)
    private IssPassTimesRequest request;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IssPassTimesResponse> response;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public IssPassTimesRequest getRequest() {
        return request;
    }

    public void setRequest(IssPassTimesRequest request) {
        this.request = request;
    }

    public List<IssPassTimesResponse> getResponse() {
        return response;
    }

    public void setResponse(List<IssPassTimesResponse> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "IssPassTimes{" +
                "Id=" + Id +
                ", request=" + request +
                ", response=" + response +
                '}';
    }

    // {"request":{"altitude":100,"datetime":1614797020,"passes":5,"latitude":65.0,"longitude":65.0},
    // "response":[
    // {"duration":414,"risetime":1614810284},
    // {"duration":494,"risetime":1614815974},
    // {"duration":464,"risetime":1614821723},
    // {"duration":261,"risetime":1614827544},
    // {"duration":366,"risetime":1614893882}],
    // "message":"success"}
}
