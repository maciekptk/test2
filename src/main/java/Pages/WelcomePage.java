package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class WelcomePage extends MainPage {

    @FindBy(css = "[href$='index.htm']")
    private WebElement homeButton;

    public WelcomePage(WebDriver driver, ITestContext context){
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public IndexPage clickHomeButton(String url, ITestContext context){
        homeButton.click();
        return new IndexPage(driver, url, context);
    }
}
