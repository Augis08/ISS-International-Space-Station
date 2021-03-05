package service;

import entity.IssSpeed;
import repositories.issSpeed.IssSpeedRepository;

import java.util.List;

public class IssSpeedService {

    private final IssSpeedRepository IssSpeedRepository;

    public IssSpeedService(IssSpeedRepository IssSpeedRepository) {
        this.IssSpeedRepository = IssSpeedRepository;
    }

    public void saveIssSpeed(IssSpeed issSpeed) {
        IssSpeedRepository.save(issSpeed);
    }

    public List<IssSpeed> findAll() {
        return IssSpeedRepository.findAll();
    }
}
