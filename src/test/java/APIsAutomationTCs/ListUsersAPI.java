package APIsAutomationTCs;

import Configuration.HeaderConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ListUsersAPI {

    public static void main(String[] args){
        try {
            HeaderConfig header = new HeaderConfig();
            RestAssured.baseURI = "https://reqres.in/api/users";
            Response response = RestAssured.given().relaxedHTTPSValidation().headers(header.defaultHeaders()).
                    baseUri(RestAssured.baseURI).queryParam("page", "2").get();

            System.out.println("Status Code: " + response.getStatusCode());
            Assert.assertEquals("Status Code Validation", 200, response.getStatusCode());
            System.out.println("Response JSON Body: " + response.getBody().asString());

        } catch (Exception ex) {
            System.out.println("Exception Triggered! : " + ex.getMessage());
        }
    }
}
