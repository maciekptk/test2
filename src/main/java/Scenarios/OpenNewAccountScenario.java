package Scenarios;

import Pages.OpenNewAccountPage;
import Pages.OverviewPage;

public class OpenNewAccountScenario implements Scenario<OverviewPage, OpenNewAccountPage> {

    @Override
    public OpenNewAccountPage run(OverviewPage entry) {
        return entry.clickOpenNewAccountLink()
                .selectAccountType()
                .selectFromAccountId()
                .clickOpenNewAccountButton();
    }

}
