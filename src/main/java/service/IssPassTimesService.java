package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.IssPassTimes;
import entity.IssPassTimesResponse;
import org.json.simple.JSONObject;
import repositories.issPassTimes.IssPassTimesRepository;
import utilities.JsonUtils;

import java.util.List;

public class IssPassTimesService {

    private final IssPassTimesRepository issPassTimesRepository;

    public IssPassTimesService(IssPassTimesRepository issPassTimesRepository) {
        this.issPassTimesRepository = issPassTimesRepository;
    }

    public void saveIssPassTimes(JSONObject jsonObject) throws JsonProcessingException {
        IssPassTimes issPassTimes = JsonUtils.fromJson(jsonObject.toString(), IssPassTimes.class);
        issPassTimesRepository.save(issPassTimes);
    }

    public void saveIssPassTimes(String jsonString) throws Exception {
        IssPassTimes issPassTimes = JsonUtils.fromJson(jsonString, IssPassTimes.class);
        issPassTimesRepository.save(issPassTimes);
    }

    public List<IssPassTimes> findAll() {
        return issPassTimesRepository.findAll();
    }

    public List<IssPassTimesResponse> getIssPassTimes (IssPassTimes issPassTimes){
        return new IssPassTimes().getResponse();
    }
}
