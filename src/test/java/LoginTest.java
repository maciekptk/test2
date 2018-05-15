import Scenarios.LoginScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    @Test
    public void shouldLogin(){
        indexPage.run(new LoginScenario(username, storedPassword))
        .loginAssertion
        .isAccountOverviewSectionDisplayed();
    }
}
