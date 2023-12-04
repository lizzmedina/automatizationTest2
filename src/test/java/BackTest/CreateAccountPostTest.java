package BackTest;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateAccountPostTest {
    @Test
    public void PostCreateAccount_test_1() {
        given()
                .contentType("application/json")
                .when().post("https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=15209&newAccountType=1&fromAccountId=19782")
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}