import Scenarios.RegisterScenario;
import org.testng.annotations.Test;

public class RegisterTest extends TestData {

    @Test
    public void shouldRegister(){
        indexPage.run(new RegisterScenario())
                .registerAssertion.isWelcomeMessageDisplayed();
    }
}
