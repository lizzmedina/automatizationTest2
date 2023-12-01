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

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
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
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void SuccesRegisterTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.getRegisterTittle(), "Signing up is easy!");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.writeName("Sergio");
            registerPage.writeLastName("Paz");
            registerPage.writeAddress("calle falsa 123");
            registerPage.writeCity("tulua");
            registerPage.writeState("valle");
            registerPage.writeZipCode("abc123");
            registerPage.writePhoneNumber("3126589794");
            registerPage.writeSsn("nose123");
            registerPage.writeUserName("liza123");
            registerPage.writePassword("123456");
            registerPage.writeRepeatPassword("123456");

            test.log(Status.PASS, "Completó los datos de registro de forma correcta");

            registerPage.clickRegisterButton();
            test.log(Status.PASS, "Completó el registro");

            Assertions.assertEquals(registerPage.getSuccessMessage(), "Your account was created successfully. You are now logged in.");
            test.log(Status.PASS, "Validó que el registro se haya hecho de forma exitosa");

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Falló la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
