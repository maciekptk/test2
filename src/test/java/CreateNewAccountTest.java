import Scenarios.LoginScenario;
import Scenarios.OpenNewAccountScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends MainTest {

//    @BeforeTest
//    public void prepare(String username, String password){
//        overviewPage = indexPage.run(new LoginScenario(username, password));
//    }

    @Test
    public void shouldCreateNewAccount(){
        indexPage.run(new LoginScenario(username, storedPassword))
                .run(new OpenNewAccountScenario())
                .accountAssertion
                .isConfirmationDisplayed();
    }
}
