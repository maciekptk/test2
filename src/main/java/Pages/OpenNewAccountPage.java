package Pages;

import Assertions.AccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class OpenNewAccountPage extends MainPage {

    public AccountAssertion accountAssertion;

    @FindBy(css = "#type")
    private WebElement setAccountType;

    @FindBy(css = "#fromAccountId")
    private WebElement setFromAccountId;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;

    @FindBy(css = "[id='newAccountId']")
    private WebElement newAccountId;

    public OpenNewAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        accountAssertion = new AccountAssertion(driver, context);
    }

    public OpenNewAccountPage selectAccountType(String accountType){
        new Select(setAccountType).selectByValue(accountType);
        return this;
    }

    public OpenNewAccountPage selectFromAccountId(String accountKey){
        String accountKeyName = getContextAttribute(accountKey);
        new Select(setFromAccountId).selectByValue(accountKeyName);
        return this;
    }

    public OpenNewAccountPage clickOpenNewAccountButton(){
        openNewAccountButton.click();
        return this;
    }

//    public OpenNewAccountPage getNewAccountId(String newAccountNumber){
//        String accountValue = newAccountId.getText();
//        setContextAttribute(newAccountNumber, accountValue);
//        return this;
//    }
}
