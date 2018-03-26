import Scenarios.RegisterScenario;
import Scenarios.TransferScenario;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class TransferTest extends MainTest {

    @BeforeTest
    @Parameters({"firstName", "lastName", "street", "city", "state", "zipCode", "password", "usernameTemplate", "ssnTemplate"})
    public void prepareRegisteredUser(String firstName, String lastName, String street, String city, String state, String zipCode, String password, String usernameTemplate, String ssnTemplate) {

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);
        String username = usernameTemplate + randomInt;
        String ssn = ssnTemplate + randomInt;

        indexPage.run(new RegisterScenario(firstName, lastName, street, city, state, zipCode, password, usernameTemplate, ssnTemplate, username, ssn))
                .clickHomeButton();
    }

    @Test
    @Parameters({"transferAmount"})
    public void shouldTransfer(String transferAmount){
        indexPage.run(new TransferScenario(transferAmount))
                .transferAssertion.isConfirmationMessageDisplayed();
    }

    @Test
    public void emptyAmountTranfer(){
        String transferAmount = "";
        indexPage.run(new TransferScenario(transferAmount))
                .transferAssertion.isEmptyAmountErrorDisplayed();
    }

    @Test
    public void invalidAmountTranfer(){
        String transferAmount = "qwerty";
        indexPage.run(new TransferScenario(transferAmount))
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }

    @Test
    //failujacy test który wykrywa, że dozwolone jest zrobienie przelewu na kwotę = 0
    public void zeroAmountTranfer() {
        String transferAmount = "0";
        indexPage.run(new TransferScenario(transferAmount))
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }
}