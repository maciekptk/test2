package Scenarios;

import Pages.OpenAccountPage;
import Pages.OverviewPage;

public class OpenNewAccountScenario implements Scenario<OverviewPage, OpenAccountPage> {

    @Override
    public OpenAccountPage run(OverviewPage entry) {
        return entry.clickOpenNewAccountLink()
                .selectAccountType()
                .selectFromAccountId()
                .clickOpenNewAccountButton();
    }

}
