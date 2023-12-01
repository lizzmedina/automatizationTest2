import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends BasePage {
        private By transferLink = By.xpath("//a[normalize-space()='Transfer Funds']");        private By tittlePage = By.xpath("//h1[normalize-space()='Transfer Funds']");        private By amountToTransferInput = By.id("amount");
        private By selectSourceAccount = By.id("fromAccountId");
        private By sourceAccountNumber = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
        private By selectDestinationAccount = By.id("toAccountId");
        private By destinationNumberAccount = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
        private By transferButton =By.xpath("//input[@value='Transfer']");
        private By succesMessageTransfer = By.xpath("//h1[normalize-space()='Transfer Complete!']");

        public TransferPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public void writeAmountToTransfer(String amount) throws InterruptedException {
            sendText(amount, amountToTransferInput);
        }
        public void clickSourceAccounntSelect() throws InterruptedException {
            click(selectSourceAccount);
        }
        public void clickSourceAccounntNumber() throws InterruptedException {
            click(sourceAccountNumber);
        }
        public void clickDestinationAccounntSelect() throws InterruptedException {
            click(selectDestinationAccount);
        }
        public void clickDestinationAccounntNumber() throws InterruptedException {
            click(destinationNumberAccount);
        }

        public void clickTransferLink() throws InterruptedException {
            click(transferLink);
        }
        public void clickTransferButton() throws InterruptedException {
            click(transferButton);
        }

        public String getTittle() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println("Mensaje titulo: " + getText(tittlePage));
            return this.getText(tittlePage);
        }
    public String getSuccesMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Mensaje de transferencia exitosa: " + getText(succesMessageTransfer));
        return this.getText(succesMessageTransfer);
    }
}
