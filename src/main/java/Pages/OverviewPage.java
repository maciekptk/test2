package Pages;

import Assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import java.util.List;

public class OverviewPage extends MainPage {
    public LoginAssertion loginAssertion;

    @FindBy(css = "[href$='transfer.htm']")
    private WebElement transferFundsLink;

    @FindBy(css = "[href$='openaccount.htm']")
    private WebElement openNewAccountLink;

    @FindBy(css = "[href*='activity.htm']")
    private List<WebElement> listOfAccountNumbers;

    public OverviewPage(WebDriver driver, ITestContext context){
        super(driver, context);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver, context);
    }

    public OverviewPage getAccountNumber(String accountKeyName){
        String accountValue = listOfAccountNumbers.get(0).getText();
        setContextAttribute(accountKeyName, accountValue);
        return this;
    }

    public TransferPage clickTransferFundsLink(){
        transferFundsLink.click();
        return new TransferPage(driver, getContext());
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        openNewAccountLink.click();
        return new OpenNewAccountPage(driver, getContext());
    }
}
