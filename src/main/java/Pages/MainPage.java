package Pages;

import Scenarios.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

public abstract class MainPage {

    protected WebDriver driver;
    private ITestContext context;

    public MainPage(WebDriver driver, ITestContext context){
        this.driver = driver;
        this.context = context;
    }

    protected void setContextAttribute(String attribute, String value){
        context.setAttribute(attribute, value);
    }

    protected String getContextAttribute(String attribute){
        return context.getAttribute(attribute).toString();
    }

    protected ITestContext getContext(){
        return this.context;
    }

    public <I extends MainPage, O extends MainPage> O run(Scenario<I, O> scenario) {
        return scenario.run((I) this);
    }

    public boolean waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
