import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ActivityAccountPage extends BasePage {
    private By accountOverviewLink = By.xpath("//a[normalize-space()='Accounts Overview']");
    private By textToVerify = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");
    private By accountColumLink = By.xpath("//a[normalize-space()='14454']");
    private By accountDetailsTittle = By.xpath("//h1[normalize-space()='Account Details']");
    private By selectActiviyPeriod = By.xpath("//select[@id='month']");
    private By allActiviyPeriodOption = By.xpath("//select[@id='month']//option[@value='All'][normalize-space()='All']");

    private By selectType = By.xpath("//select[@id='transactionType']");
    private By allTypeOption = By.xpath("//select[@id='transactionType']//option[@value='All'][normalize-space()='All']");
    private By goButton = By.xpath("//input[@value='Go']");

    public ActivityAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAccountOverview() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        click(accountOverviewLink);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickAccountColum() throws InterruptedException {
        Thread.sleep(1000);
        click(accountColumLink);
    }
    public void clickSelectActivityPeriod() throws InterruptedException {
        Thread.sleep(1000);
        click(selectActiviyPeriod);
    }
    public void clickActivityPeriodAll() throws InterruptedException {
        Thread.sleep(1000);
        click(allActiviyPeriodOption);
    }
    public void clickSelectType() throws InterruptedException {
        click(selectType);
    }
    public void clickTypeAll() throws InterruptedException {
        Thread.sleep(1000);
        click(allTypeOption);
    }

    public void clickGoButton() throws InterruptedException {
        click(goButton);
    }

    public String getTextToVerifyPage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Me encuentro en la página de resumen de cuenta: " + getText(textToVerify));
        return this.getText(textToVerify);
    }
    public String getTittleDetailPage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Me encuentro en la página de detalles de cuenta: " + getText(accountDetailsTittle));
        return this.getText(accountDetailsTittle);
    }
}
