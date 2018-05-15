package Scenarios;

import Pages.OpenNewAccountPage;
import Pages.OverviewPage;

public class OpenNewAccountScenario implements Scenario<OverviewPage, OpenNewAccountPage> {

    private final String ACCOUNT_TYPE = "SAVINGS";
    private final String ACCOUNT_KEY = "accountKeyName";

    @Override
    public OpenNewAccountPage run(OverviewPage entry) {
        return entry.getAccountNumber(ACCOUNT_KEY)
                .clickOpenNewAccountLink()
                .selectAccountType(ACCOUNT_TYPE)
                .selectFromAccountId(ACCOUNT_KEY)
                .clickOpenNewAccountButton();
    }

}
