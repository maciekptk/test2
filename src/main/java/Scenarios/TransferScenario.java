package Scenarios;

import Pages.IndexPage;
import Pages.TransferPage;

public class TransferScenario implements Scenario<IndexPage, TransferPage> {

    String transferAmount;

    public TransferScenario(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Override
    public TransferPage run(IndexPage entry){
        return entry.clickTransferFundsLink()
                .setAmount(transferAmount)
                .setDefaultFromAccountId()
                .setDefaultToAccountId()
                .clickTransferButton();
    }
}
