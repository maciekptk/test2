package Pages;

import Assertions.TransferAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransferPage extends MainPage {
    public TransferAssertion transferAssertion;

    @FindBy(css = "[name='amount']")
    private WebElement amountInput;

    @FindBy(css = "[id='fromAccountId'] option:first-child")
    private WebElement fromAccountSelector;

    @FindBy(css = "[id='toAccountId'] option:first-child")
    private WebElement toAccountSelector;

    @FindBy(css = "[value='Transfer']")
    private WebElement transferButton;

    public TransferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        transferAssertion = new TransferAssertion(driver);
    }

    public TransferPage setAmount(String transferAmount) {
        amountInput.sendKeys(transferAmount);
        return this;
    }

    public TransferPage setDefaultFromAccountId(){
        fromAccountSelector.click();
        return this;
    }

    public TransferPage setDefaultToAccountId(){
        toAccountSelector.click();
        return this;
    }

//    public TransferPage setFromAccountId(String fromAccountId) {
//        fromAccountSelector.click();
//        return this;
//    }
//
//    public TransferPage setToAccountId(String toAccountId) {
//        toAccountSelector.click();
//        return this;
//    }

    public TransferPage clickTransferButton() {
        transferButton.click();
        return this;
    }
}
