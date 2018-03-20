import Scenarios.LoginScenario;
import Scenarios.OpenNewAccountScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends MainTest {

//    String username = "johnwayne54";
//    String password = "asdfzxcv";

    @BeforeTest
//    public void beforeTest(){
//        overviewPage = indexPage.run(new LoginScenario(username, password));
//    }
    @Parameters({"username", "password"})
    public void prepare(String username, String password){
        overviewPage = indexPage.run(new LoginScenario(username, password));
    }

    @Test
    public void shouldCreateNewAccount(){
        overviewPage.run(new OpenNewAccountScenario())
                .accountAssertion.isConfirmationDisplayed();
    }
}
