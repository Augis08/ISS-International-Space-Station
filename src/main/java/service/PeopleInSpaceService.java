package service;

import entity.PeopleInSpace;
import repositories.peopleInSpace.PeopleInSpaceRepository;
import utilities.JsonUtils;

import java.util.List;

public class PeopleInSpaceService {

    private final PeopleInSpaceRepository PeopleInSpaceRepository;

    public PeopleInSpaceService(PeopleInSpaceRepository PeopleInSpaceRepository) {
        this.PeopleInSpaceRepository = PeopleInSpaceRepository;
    }

    public void savePeopleInSpace(String jsonString) throws Exception {
        PeopleInSpace PeopleInSpace = JsonUtils.fromJson(jsonString, PeopleInSpace.class);
        PeopleInSpaceRepository.save(PeopleInSpace);
    }

    public List<PeopleInSpace> findAll() {
        return PeopleInSpaceRepository.findAll();
    }
}
