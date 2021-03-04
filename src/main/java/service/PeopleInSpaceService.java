package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.PeopleInSpace;
import org.json.simple.JSONObject;
import repositories.peopleInSpace.PeopleInSpaceRepository;
import utilities.JsonUtils;

import java.util.List;

        public class PeopleInSpaceService {

            private final PeopleInSpaceRepository PeopleInSpaceRepository;

            public PeopleInSpaceService(PeopleInSpaceRepository PeopleInSpaceRepository) {
                this.PeopleInSpaceRepository = PeopleInSpaceRepository;
            }

            public void savePeopleInSpace(JSONObject jsonObject) throws JsonProcessingException {
                PeopleInSpace PeopleInSpace = JsonUtils.fromJson(jsonObject.toString(), PeopleInSpace.class);
                PeopleInSpaceRepository.save(PeopleInSpace);
            }

            public void savePeopleInSpace(String jsonString) throws Exception {
                PeopleInSpace PeopleInSpace = JsonUtils.fromJson(jsonString, PeopleInSpace.class);
                PeopleInSpaceRepository.save(PeopleInSpace);
            }

            public List<PeopleInSpace> findAll() {
                return PeopleInSpaceRepository.findAll();
            }
        }
