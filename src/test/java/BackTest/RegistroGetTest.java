package BackTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RegistroGetTest {
    static final String URL = "https://parabank.parasoft.com/parabank/register.htm";

    @Test

    public void get (){
        Integer statusCode = given().when().get(URL).getStatusCode();
        System.out.println("the status response is: " + statusCode);
        given().when().get(URL).then().assertThat().statusCode(200);
    }
}
