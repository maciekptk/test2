import Scenarios.RegisterScenario;
import Scenarios.TransferScenario;
import org.testng.annotations.Test;

public class TransferTest extends MainTest {

    @Test
    public void shouldTransfer(){
        indexPage.run(new RegisterScenario())
                .clickHomeButton()
                .run(new TransferScenario())
                .transferAssertion.isConfirmationMessageDisplayed();
    }

    @Test
    public void emptyAmountTranfer(){
        indexPage.run(new RegisterScenario())
                .clickHomeButton()
                .clickTransferFundsLink()
                .setAmount("")
                .clickTransferButton()
                .transferAssertion.isEmptyAmountErrorDisplayed();
    }

    @Test
    public void invalidAmountTranfer(){
        indexPage.run(new RegisterScenario())
                .clickHomeButton()
                .clickTransferFundsLink()
                .setAmount("qwerty")
                .clickTransferButton()
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }

    @Test
    //test który wykrywa, że dozwolone jest zrobienie przelewu na kwotę = 0
    public void zeroAmountTranfer() {
        indexPage.run(new RegisterScenario())
                .clickHomeButton()
                .clickTransferFundsLink()
                .setAmount("0")
                .clickTransferButton()
                .transferAssertion.isInvalidAmountErrorDisplayed();
    }
}