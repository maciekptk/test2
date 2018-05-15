import Scenarios.RegisterScenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest extends MainTest {

    @Test
    public void shouldRegister() {

        registerPage
                .registerAssertion
                .isWelcomeMessageDisplayed();
    }
}
