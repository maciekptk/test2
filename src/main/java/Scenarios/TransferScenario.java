package Scenarios;

import Pages.IndexPage;
import Pages.TransferPage;

public class TransferScenario implements Scenario<IndexPage, TransferPage> {

    String transferAmount = "50.00";

    @Override
    public TransferPage run(IndexPage entry){
        return entry.clickTransferFundsLink()
                .setAmount(transferAmount)
                .setDefaultFromAccountId()
                .setDefaultToAccountId()
                .clickTransferButton();
    }
}
