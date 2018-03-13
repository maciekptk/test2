package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {

    @FindBy(css = "[href^='register.htm']")
    private WebElement registerLink;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IndexPage openIndexPage(){
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();
        return this;
    }

    public RegisterPage clickRegisterLink(){
        registerLink.click();
        return new RegisterPage(driver);
    }
}
