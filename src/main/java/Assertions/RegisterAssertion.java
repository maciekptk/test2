package Assertions;

import Pages.Helpers;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RegisterAssertion extends MainPage {

//    Helpers theUsername = new Helpers(); Get "username" from Helpers
//    String username = theUsername.getTheUsername();

    @FindBy(css = ".title")
    private List<WebElement> welcomeMessage;

    public RegisterAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isWelcomeMessageDisplayed(){
        //Assert.assertEquals(welcomeMessage.getText(), "Welcome " + username); Compare text
        Assert.assertTrue(welcomeMessage.size()!=0);
    }
}
