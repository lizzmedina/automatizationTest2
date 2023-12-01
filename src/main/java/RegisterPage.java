import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    private By tittle = By.xpath("//h1[normalize-space()='Signing up is easy!']");
    private By firtsName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By userName = By.id("customer.username");
    private By password = By.id("customer.password");
    private By repeatePassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By successMessage = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getRegisterTittle() throws InterruptedException {
        System.out.println("Me encuentro en la página de Registro: " + getText(tittle));
        return this.getText(tittle);
    }

    public void writeName(String name) throws InterruptedException {
        sendText(name, firtsName);
    }

    public void writeLastName(String lastNameParam) throws InterruptedException {
        sendText(lastNameParam, lastName);
    }

    public void writeAddress(String addressParam) throws InterruptedException {
        sendText(addressParam, address);
    }

    public void writeCity(String cityParam) throws InterruptedException {
        sendText(cityParam, city);
    }

    public void writeState(String stateParam) throws InterruptedException {
        sendText(stateParam, state);
    }

    public void writeZipCode(String stateParam) throws InterruptedException {
        sendText(stateParam, zipCode);
    }
    public void writePhoneNumber(String phoneNumberParam) throws InterruptedException {
        sendText(phoneNumberParam, phoneNumber);
    }

    public void writeSsn(String ssnParam) throws InterruptedException {
        sendText(ssnParam, ssn);
    }

    public void writeUserName(String userNameParam) throws InterruptedException {
        sendText(userNameParam, userName);
    }

    public void writePassword(String passwordParam) throws InterruptedException {
        sendText(passwordParam, password);
    }

    public void writeRepeatPassword(String passwordRepeatedParam) throws InterruptedException {
        sendText(passwordRepeatedParam, repeatePassword);
    }

    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(1000);
        click(registerButton);
    }

    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Se creò la cuenta: " + getText(successMessage));
        return this.getText(successMessage);
    }


}
