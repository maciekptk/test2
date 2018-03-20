package Pages;

import Assertions.AccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends MainPage {

    public AccountAssertion accountAssertion;

    @FindBy(css = "[id='type']")
    private WebElement accountType;

    @FindBy(css = "[id='fromAccountId']")
    private WebElement fromAccountId;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;

    public OpenAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        accountAssertion = new AccountAssertion(driver);
    }

    public OpenAccountPage selectAccountType(){
        accountType.click();
        return this;
    }

    public OpenAccountPage selectFromAccountId(){
        fromAccountId.click();
        return this;
    }

    public OpenAccountPage clickOpenNewAccountButton(){
        openNewAccountButton.click();
        return this;
    }
}
