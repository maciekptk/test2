package Scenarios;

import Pages.IndexPage;
import Pages.OpenAccountPage;
import Pages.OverviewPage;

public class LoginScenario implements Scenario<IndexPage, OverviewPage> {

    private String username;
    private String password;

    public LoginScenario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public OverviewPage run(IndexPage entry){
        return entry.openIndexPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton();
    }
}
