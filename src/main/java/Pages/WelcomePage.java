package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends MainPage {

    @FindBy(css = "[href$='index.htm']")
    private WebElement homeButton;

    public WelcomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public IndexPage clickHomeButton(String url){
        homeButton.click();
        return new IndexPage(driver, url);
    }
}
