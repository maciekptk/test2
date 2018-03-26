import Pages.IndexPage;
import Pages.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    OverviewPage overviewPage;
    protected String url;
    protected ITestContext context;

    @BeforeTest
    @Parameters({"url"})
    public void before(ITestContext context, String url) {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver, url);
        this.url = url;
        this.context = context;

    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
