package Assertions;

import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TransferAssertion extends MainPage {

    @FindBy(css = ".title")
    private List<WebElement> confirmationMessage;

    public TransferAssertion(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isConfirmationMessageDisplayed(){
        Assert.assertTrue(confirmationMessage.size()!=0);
        System.out.println("zmiany, utworzenie nowego brancha");
    }
}
