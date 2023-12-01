import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage {
    private By openAccountLink = By.xpath("//a[normalize-space()='Open New Account']");
    private By typeAccount = By.id("type");
    private By savingOption = By.xpath("//*[@id=\"type\"]/option[2]");
    private By openAccountButton = By.xpath("//input[@value='Open New Account']");
    private By successMessage = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");
// *Balance includes deposits that may be subject to holds -> mensaje para verificar el resumen de cuentas
    // xpath -> ("//td[contains(text(),'*Balance includes deposits that may be subject to ')]")

    public CreateAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOpenAccountLink() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        click(openAccountLink);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickTypeAccount() throws InterruptedException {
       click(typeAccount);
    }

    public void clickSavingOption() throws InterruptedException {
       click(savingOption);

    }

    public void clickOpenNewAccountButton() throws InterruptedException {
        click(openAccountButton);
    }

    public String getSucccesMessage() throws InterruptedException {
        System.out.println("Me encuentro en la página de creación de cuenta: " + getText(successMessage));
        return this.getText(successMessage);
    }
}
