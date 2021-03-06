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
}
