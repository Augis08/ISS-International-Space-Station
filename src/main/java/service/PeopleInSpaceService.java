package service;

import entity.PeopleInSpace;
import repositories.peopleInSpace.PeopleInSpaceRepository;
import java.util.List;

public class PeopleInSpaceService {

    private final PeopleInSpaceRepository PeopleInSpaceRepository;

    public PeopleInSpaceService(PeopleInSpaceRepository PeopleInSpaceRepository) {
        this.PeopleInSpaceRepository = PeopleInSpaceRepository;
    }

    public void savePeopleInSpace(PeopleInSpace peopleInSpace) {
        PeopleInSpaceRepository.save(peopleInSpace);
    }

    public List<PeopleInSpace> findAll() {
        return PeopleInSpaceRepository.findAll();
    }
}
