package service;

import entity.IssPassTimes;
import entity.IssPassTimesResponse;
import repositories.issPassTimes.IssPassTimesRepository;
import utilities.JsonUtils;

import java.util.List;

public class IssPassTimesService {

    private final IssPassTimesRepository issPassTimesRepository;

    public IssPassTimesService(IssPassTimesRepository issPassTimesRepository) {
        this.issPassTimesRepository = issPassTimesRepository;
    }

    public void saveIssPassTimes(IssPassTimes issPassTimes) {
        issPassTimesRepository.save(issPassTimes);
    }

    public List<IssPassTimes> findAll() {
        return issPassTimesRepository.findAll();
    }

    public List<IssPassTimesResponse> getIssPassTimes (IssPassTimes issPassTimes){
        return new IssPassTimes().getResponse();
    }
}
