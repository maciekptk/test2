package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {

    @FindBy(css = "[href^='register.htm']")
    private WebElement registerLink;

    @FindBy(css = "[href$='transfer.htm']")
    private WebElement transferFundsLink;

    @FindBy(css = "[name='username']")
    private WebElement inputUsername;

    @FindBy(css = "[name='password']")
    private WebElement inputPassword;

    @FindBy(css = "[value='Log In']")
    private WebElement loginButton;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IndexPage openIndexPage(){
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();
        return this;
    }

    public IndexPage setUsername(String username){
        inputUsername.sendKeys(username);
        return this;
    }

    public IndexPage setPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginButton(){
        loginButton.click();
        return new OverviewPage(driver);
    }



    public RegisterPage clickRegisterLink(){
        registerLink.click();
        return new RegisterPage(driver);
    }

    public TransferPage clickTransferFundsLink(){
        transferFundsLink.click();
        return new TransferPage(driver);
    }
}
