import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransferTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/TransferTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        TransferPage transferPage = new TransferPage(driver, wait);
        transferPage.setUp();
        transferPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
   @Tag("Transfer")
    @Tag("ALL")
    public void LoginExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de transferencia Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        TransferPage transferPage = new TransferPage(driver, wait);

        try {
            transferPage.writeUserNameLogin("lizdaneris123");
            transferPage.writePasswordLogin("123456");
            transferPage.clickLogin();
            transferPage.clickTransferLink();
            test.log(Status.PASS, "Ingreso a la página de transferencia");
            Assertions.assertEquals(transferPage.getTittle(), "Transfer Funds");

            transferPage.writeAmountToTransfer("200");
            transferPage.clickSourceAccounntSelect();
            transferPage.clickSourceAccounntNumber();
            transferPage.clickDestinationAccounntSelect();
            transferPage.clickDestinationAccounntNumber();
            transferPage.clickTransferButton();
            test.log(Status.PASS, "Se completan de forma correcta los datos de transferencia de fondos");

            Assertions.assertEquals(transferPage.getSuccesMessage(), "Transfer Complete!");
            test.log(Status.PASS, "Validamos que se haya realizado la transferencia correctamente");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Falló la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        TransferPage transferPage = new TransferPage(driver, wait);
        transferPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
