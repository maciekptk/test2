import Scenarios.LoginScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    @Test
    @Parameters({"username", "password"})
    public void shouldLogin(String username, String password){
        indexPage.run(new LoginScenario(username, password))
        .loginAssertion
        .isAccountOverviewSectionDisplayed();
    }
}
