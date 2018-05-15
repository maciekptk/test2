import Pages.IndexPage;
import Pages.OverviewPage;
import Pages.RegisterPage;
import Scenarios.RegisterScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Random;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;
    RegisterPage registerPage;
    OverviewPage overviewPage;
    protected String url;
    protected ITestContext context;

    String username;
    String ssn;
    String storedPassword;

    @BeforeSuite
    @Parameters({"url", "firstName", "lastName", "street", "city", "state", "zipCode", "password", "usernameTemplate", "ssnTemplate"})
    public void before(ITestContext context, String url, String firstName, String lastName, String street, String city, String state, String zipCode, String password, String usernameTemplate, String ssnTemplate) {

        driver = new ChromeDriver();
        indexPage = new IndexPage(driver, url, context);
        registerPage = new RegisterPage(driver, context);
        this.url = url;
        this.context = context;

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);
        username = usernameTemplate + randomInt;
        ssn = ssnTemplate + randomInt;
        storedPassword = password;

        indexPage.run(new RegisterScenario(firstName, lastName, street, city, state, zipCode, password, usernameTemplate, ssnTemplate, username, ssn))
            .clickLogout();
    }

    @AfterTest
    public void after(){
        driver.close();
    }
}
