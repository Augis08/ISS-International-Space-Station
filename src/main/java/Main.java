import org.json.simple.JSONObject;
import utility.JsonUtils;

public class Main {

        public static void main(String[] args) throws Exception {
            JSONObject jsonObject = (JSONObject) JsonReader.writeJsonSimpleDemo("/Users/arnis/Desktop/Coding/JAVA/Git/ISS/iss-now2.json");
            System.out.println(jsonObject);
            System.out.println(jsonObject.get("message"));

        Position position = JsonUtils.fromJson(jsonObject.toString(), Position.class);
            System.out.println(position);
        }
    }

