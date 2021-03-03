package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "issPassTimes")
public class IssPassTimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private IssPassTimesRequest issPassTimesRequest;
    private List<IssPassTimesResponse> issPassTimesResponse;


    // {"request":{"altitude":100,"datetime":1614797020,"passes":5,"latitude":65.0,"longitude":65.0},
    // "response":[
    // {"duration":414,"risetime":1614810284},
    // {"duration":494,"risetime":1614815974},
    // {"duration":464,"risetime":1614821723},
    // {"duration":261,"risetime":1614827544},
    // {"duration":366,"risetime":1614893882}],
    // "message":"success"}
}
