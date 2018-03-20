import Pages.IndexPage;
import Pages.OverviewPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    RegisterPage registerPage;
    OverviewPage overviewPage;

    @BeforeTest
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
