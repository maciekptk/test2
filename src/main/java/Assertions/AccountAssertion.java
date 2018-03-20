package Assertions;

import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountAssertion extends MainPage {

    @FindBy(css = ".title")
    private WebElement accountCreationConfirmation;

    public AccountAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isConfirmationDisplayed(){
        Assert.assertEquals(accountCreationConfirmation.getText(), "Account Opened!");
    }
}
