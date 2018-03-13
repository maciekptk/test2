import Pages.IndexPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    RegisterPage registerPage;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void after(){
        driver.close();
    }
}
