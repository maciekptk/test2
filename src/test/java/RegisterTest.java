import Scenarios.RegisterScenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest extends MainTest {

    @Parameters({"firstName", "lastName", "street", "city", "state", "zipCode", "password", "usernameTemplate", "ssnTemplate"})
    @Test
    public void shouldRegister(String firstName, String lastName, String street, String city, String state, String zipCode, String password, String usernameTemplate, String ssnTemplate) {

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);
        String username = usernameTemplate + randomInt;
        String ssn = ssnTemplate + randomInt;

        indexPage.run(new RegisterScenario(firstName, lastName, street, city, state, zipCode, password, usernameTemplate, ssnTemplate, username, ssn)) // parametry w RegisterScenario z konstruktora, dodac dane testowe tutaj (w tescie)
                .registerAssertion
                .isWelcomeMessageDisplayed();
    }
}
