package Entity;

public class IssPassTimesResponse {
    private int duration;
    private int risetime;

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
        return "IssPassTimesResponse{" +
                "duration=" + duration +
                ", risetime=" + risetime +
                '}';
    }

    //    "response":[
    // {"duration":414,"risetime":1614810284},
    // {"duration":494,"risetime":1614815974},
    // {"duration":464,"risetime":1614821723},
    // {"duration":261,"risetime":1614827544},
    // {"duration":366,"risetime":1614893882}],
    // "message":"success"}
}
