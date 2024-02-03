package APIsAutomationTCs;

import Configuration.HeaderConfig;
import Data.JsonReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class CreateUserAPI {

    public static void main(String[] args){
        try {
            HeaderConfig header = new HeaderConfig();
            JsonReader jsonReader = new JsonReader();
            String json_body = jsonReader.ReadJsonFile("CreateUserBody.json");
            RestAssured.baseURI = "https://reqres.in/api/users";
            Response response = RestAssured.given().relaxedHTTPSValidation().headers(header.defaultHeaders()).body(json_body).
                    baseUri(RestAssured.baseURI).post();

            System.out.println("Status Code: " + response.getStatusCode());
            Assert.assertEquals("Status Code Validation", 200, response.getStatusCode());
            System.out.println("Response JSON Body: " + response.getBody().asString());
            JsonPath json_path = new JsonPath(response.getBody().asString());
            String name = json_path.get("name").toString();
            Assert.assertEquals("Job isn't updated ! :","name", name);

        } catch (Exception ex) {
            System.out.println("Exception Triggered! : " + ex.getMessage());
        }
    }
}
