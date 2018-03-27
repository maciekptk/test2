package Pages;

import Assertions.AccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class OpenNewAccountPage extends MainPage {

    public AccountAssertion accountAssertion;

    @FindBy(css = "[id='type'] [value='SAVINGS']")
    private WebElement accountType;

    @FindBy(css = "[id='fromAccountId'] option:first-child")
    private WebElement fromAccountId;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;

    public OpenNewAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        accountAssertion = new AccountAssertion(driver, context);
    }

    public OpenNewAccountPage selectAccountType(){
        accountType.click();
        return this;
    }

    public OpenNewAccountPage selectFromAccountId(){
        fromAccountId.click();
        return this;
    }

    public OpenNewAccountPage clickOpenNewAccountButton(){
        openNewAccountButton.click();
        return this;
    }
}
