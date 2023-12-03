
import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/ActivityAccountPageTest.html");
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
        ActivityAccountPage activityAccount = new ActivityAccountPage(driver, wait);
        activityAccount.setUp();
        activityAccount.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("details")
    @Tag("ALL")
    public void LoginExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de consulta consulta detalles de cuenta");
        test.log(Status.INFO, "Comienza el Test");
        ActivityAccountPage activityAccount = new ActivityAccountPage(driver, wait);

        try {
            activityAccount.writeUserNameLogin("lizdaneris123");
            activityAccount.writePasswordLogin("123456");
            activityAccount.clickLogin();

            activityAccount.clickAccountOverview();
            test.log(Status.PASS, "Ingreso a la página detalles de cuenta");
            Assertions.assertEquals(activityAccount.getTextToVerifyPage(), "*Balance includes deposits that may be subject to holds");

            activityAccount.clickAccountColum();
            activityAccount.clickSelectActivityPeriod();
            activityAccount.clickActivityPeriodAll();
            activityAccount.clickSelectType();
            activityAccount.clickTypeAll();
            activityAccount.clickGoButton();
            test.log(Status.PASS, "Se completan de forma correcta los consulta de detalles de cuenta");

            Assertions.assertEquals(activityAccount.getTittleDetailPage(), "Account Details");
            test.log(Status.PASS, "Validamos que se haya realizado la transferencia correctamente");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Falló la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        ActivityAccountPage activityAccount = new ActivityAccountPage(driver, wait);
        activityAccount.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
