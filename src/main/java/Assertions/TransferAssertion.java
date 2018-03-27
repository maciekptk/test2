package Assertions;

import Pages.MainPage;
import Scenarios.TransferScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;

import java.util.List;

public class TransferAssertion extends MainPage {

    @FindBy(css = ".title")
    private List<WebElement> confirmationMessage;

    @FindBy(css = "[id='amount']")
    private WebElement confirmationAmount;

    @FindBy(css = ".error")
    private List<WebElement> errorMessage;

    @FindBy(css = "[id='amount.errors']")
    private WebElement emptyAmount;

    @FindBy(css = "[id='amount.errors']")
    private WebElement invalidAmount;

    public TransferAssertion(WebDriver driver, ITestContext context){
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void isConfirmationMessageDisplayed(){
        Assert.assertTrue(confirmationMessage.size()!=0);
    }

//    public void isConfirmedAmountCorrect(){
//        Assert.assertEquals(confirmationAmount.getText(), "$" + );
//    }

    public void isErrorMessageDisplayed(){
        Assert.assertTrue(errorMessage.size()!=0);
    }

    public void isEmptyAmountErrorDisplayed(){
        Assert.assertEquals(emptyAmount.getText(), "The amount cannot be empty.");
    }

    public void isInvalidAmountErrorDisplayed(){
        Assert.assertEquals(emptyAmount.getText(), "Please enter a valid amount.");
    }
}
