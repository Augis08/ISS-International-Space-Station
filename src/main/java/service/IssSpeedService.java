package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.IssSpeed;
import org.json.simple.JSONObject;
import repositories.issSpeed.IssSpeedRepository;
import utilities.JsonUtils;

import java.util.List;

    public class IssSpeedService {

        private final IssSpeedRepository IssSpeedRepository;

        public IssSpeedService(IssSpeedRepository IssSpeedRepository) {
            this.IssSpeedRepository = IssSpeedRepository;
        }


        public void saveIssSpeedService(JSONObject jsonObject) throws JsonProcessingException {
            IssSpeed IssSpeed = JsonUtils.fromJson(jsonObject.toString(), IssSpeed.class);
            IssSpeedRepository.save(IssSpeed);
        }

        public void saveIssPassTimes(String jsonString) throws Exception {
            IssSpeed IssSpeed = JsonUtils.fromJson(jsonString, IssSpeed.class);
            IssSpeedRepository.save(IssSpeed);
        }

        public List<IssSpeed> findAll() {
            return IssSpeedRepository.findAll();
        }
    }