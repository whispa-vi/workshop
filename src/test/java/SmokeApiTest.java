import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTest {
    @Test
    void simpleTest(){
        ///AAA
        String baseUrl = "https://petstore.swagger.io/v2/";
        String body = """
           {
             "id": 0,
             "username": "string",
             "firstName": "string",
             "lastName": "string",
             "email": "string",
             "password": "string",
             "phone": "string",
             "userStatus": 0
           }""";


        Response response = given()
                .baseUri(baseUrl)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body).
                when().post("user").andReturn();
        response.body().prettyPrint();


        Assertions.assertEquals(200, response.statusCode());
    }

}

