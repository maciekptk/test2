import Scenarios.TransferScenario;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TransferTest extends MainTest {

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