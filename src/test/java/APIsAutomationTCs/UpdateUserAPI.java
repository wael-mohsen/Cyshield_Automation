package APIsAutomationTCs;

import Configuration.HeaderConfig;
import Data.JsonReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class UpdateUserAPI {

    public static void main(String[] args){
        try {
            HeaderConfig header = new HeaderConfig();
            JsonReader jsonReader = new JsonReader();
            String json_body = jsonReader.ReadJsonFile("UpdateUserBody.json");
            RestAssured.baseURI = "https://reqres.in/api/users";
            Response response = RestAssured.given().relaxedHTTPSValidation().headers(header.defaultHeaders()).body(json_body).
                    baseUri(RestAssured.baseURI).put();

            System.out.println("Status Code: " + response.getStatusCode());
            Assert.assertEquals("Status Code Validation", 200, response.getStatusCode());
            System.out.println("Response JSON Body: " + response.getBody().asString());
            JsonPath json_path = new JsonPath(response.getBody().asString());
            String job = json_path.get("job").toString();
            Assert.assertEquals("Job isn't updated ! :","zion resident", job);

        } catch (Exception ex) {
            System.out.println("Exception Triggered! : " + ex.getMessage());
        }
    }
}
