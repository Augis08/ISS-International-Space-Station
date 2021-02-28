import Entity.CurrentPosition;
import org.json.simple.JSONObject;
import utility.JsonUtils;

public class Main {

        public static void main(String[] args) throws Exception {
            String path = "/Users/Augis/Desktop/JAVA/ISS project/iss-now1.json";
            JSONObject jsonObject = (JSONObject) JsonReader.writeJsonSimpleDemo(path);

        CurrentPosition position = JsonUtils.fromJson(jsonObject.toString(), CurrentPosition.class);
            System.out.println(position);

            Project project = new Project();
        }
    }

