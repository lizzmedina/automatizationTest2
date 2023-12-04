package BackTest;

import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TransferPostTest {
    @Test
    public void PostTransfer_test_1() {

        given()
                .contentType("application/json")
                .when().post("https://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=20004&toAccountId=19782&amount=5")
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
