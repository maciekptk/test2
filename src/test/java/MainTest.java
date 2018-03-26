import Pages.IndexPage;
import Pages.OverviewPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    RegisterPage registerPage;
    OverviewPage overviewPage;

    @BeforeTest
    @Parameters({"url"})
    public void before(String url) {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver, url);
        //registerPage = new RegisterPage(driver);
    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
