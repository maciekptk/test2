import Pages.IndexPage;
import Pages.OverviewPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    OverviewPage overviewPage;
    protected String url;
    protected ITestContext context;

    @BeforeTest
    @Parameters({"url"})
    public void before(ITestContext context, String url) throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        URL hubUrl = new URL("http://192.168.43.36:4444/wd/hub");
        driver = new RemoteWebDriver(hubUrl, capabilities);
        indexPage = new IndexPage(driver, url, context);
        this.url = url;
        this.context = context;

    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
