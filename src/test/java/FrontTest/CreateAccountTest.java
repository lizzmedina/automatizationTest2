import Reportes.ExtentFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/createNewAccount.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        CreateAccountPage createAccountPage = new CreateAccountPage(driver, wait);
        createAccountPage.setUp();
        createAccountPage.getUrl("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("newAccount")
    @Tag("ALL")
    public void testCreateSavingAccount() throws InterruptedException {
        ExtentTest test = extent.createTest("Saving account creation proces");
        test.log(Status.INFO, "the test begin");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver, wait);
        RegisterPage registerPage = new RegisterPage(driver, wait);

        createAccountPage.writeUserNameLogin("lizdaneris123");
        createAccountPage.writePasswordLogin("123456");
        createAccountPage.clickLogin();

        createAccountPage.clickOpenAccountLink();
        createAccountPage.clickTypeAccount();
        createAccountPage.clickSavingOption();
        createAccountPage.clickOpenNewAccountButton();
        test.log(Status.PASS, "Account created");

        Assertions.assertEquals(createAccountPage.getSucccesMessage(),"Congratulations, your account is now open.");
        test.log(Status.PASS, "Succes message for created account checked");
    }

    @AfterEach
    public void quit() {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver, wait);
        createAccountPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}