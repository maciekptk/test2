package Assertions;

import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;

public class LoginAssertion extends MainPage {

    @FindBy(css = ".title")
    private WebElement accountOverviewSection;

    public LoginAssertion(WebDriver driver, ITestContext context){
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void isAccountOverviewSectionDisplayed(){
        Assert.assertEquals(accountOverviewSection.getText(), "Accounts Overview");
    }
}
