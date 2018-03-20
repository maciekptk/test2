import Scenarios.LoginScenario;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    String username = "johnwayne54";
    String password = "asdfzxcv";

    @Test
    public void shouldLogin(){
        indexPage.run(new LoginScenario(username, password));
    }
}
