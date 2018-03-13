package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends MainPage {

    @FindBy(css = "[href$='transfer.htm']")
    private WebElement transferFundsLink;

    public OverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TransferPage clickTransferFundsLink(){
        transferFundsLink.click();
        return new TransferPage(driver);
    }
}
