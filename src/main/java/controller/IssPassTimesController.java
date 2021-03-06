package controller;

import entity.IssPassTimes;
import repositories.issPassTimes.IssPassTimesRepository;
import service.IssPassTimesService;

import java.util.List;

public class IssPassTimesController {

    private final IssPassTimesRepository issPassTimesRepository;
    private final IssPassTimesService issPassTimesService;

    public IssPassTimesController(IssPassTimesRepository issPassTimesRepository,
                                  IssPassTimesService issPassTimesService) {
        this.issPassTimesRepository = issPassTimesRepository;
        this.issPassTimesService = issPassTimesService;
    }

    public List<IssPassTimes> findAllPassedTimes() {
        return issPassTimesRepository.findAll();
    }


}
