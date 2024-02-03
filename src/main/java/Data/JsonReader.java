package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public JSONObject registrationData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/TestData.json");
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;
        JSONObject employeeObject = (JSONObject) employeeList.get(0);
        return employeeObject;
    }

    public String ReadJsonFile(String fileName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        Object obj = jsonParser.parse(reader);
        String body = obj.toString();
        return body;
    }
}
