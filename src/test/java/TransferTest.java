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
}
