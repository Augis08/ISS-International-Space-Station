package utilities;

import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    public static Object writeJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        return new JSONParser().parse(reader);
    }
}
