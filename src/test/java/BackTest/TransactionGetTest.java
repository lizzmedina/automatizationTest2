package BackTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class TransactionGetTest {
    @Test
    public void GetTransactions_test_1() {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/accounts/16452/transactions/month/All/type/All");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se demoró: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());

    }
}