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

        registerPage = indexPage.run(new RegisterScenario(firstName, lastName, street, city, state, zipCode, password, usernameTemplate, ssnTemplate, username, ssn));
    }

    @Test
    @Parameters({"transferAmount"})
    public void shouldTransfer(String transferAmount){
        registerPage.clickHomeButton()
                .run(new TransferScenario(transferAmount))
                .transferAssertion.isConfirmationMessageDisplayed();
    }

    @Test
    @Parameters({"emptyTransferAmount"})
    public void emptyAmountTranfer(String emptyTransferAmount){
        registerPage.clickHomeButton()
                .run(new TransferScenario(emptyTransferAmount))
                .transferAssertion.isEmptyAmountErrorDisplayed();
    }

    @Test
    @Parameters({"invalidTransferAmount"})
    public void invalidAmountTranfer(String invalidTransferAmount){
        registerPage.clickHomeButton()
                .run(new TransferScenario(invalidTransferAmount))
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }

    @Test
    @Parameters({"zeroTransferAmount"})
    //failujacy test który wykrywa, że dozwolone jest zrobienie przelewu na kwotę = 0
    public void zeroAmountTranfer(String zeroTransferAmount) {
        registerPage.clickHomeButton()
                .run(new TransferScenario(zeroTransferAmount))
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }
}