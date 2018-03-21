package Scenarios;

import Pages.IndexPage;
import Pages.RegisterPage;

public class RegisterScenario implements Scenario<IndexPage, RegisterPage> {

    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    String zipCode;
    String ssnTemplate;
    String usernameTemplate;
    String password;
    String username;
    String ssn;

    public RegisterScenario(String firstName, String lastName, String street, String city, String state, String zipCode, String password, String usernameTemplate, String ssnTemplate, String username, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.ssnTemplate = ssnTemplate;
        this.usernameTemplate = usernameTemplate;
        this.password = password;
        this.username = username;
        this.ssn = ssn;
    }

    @Override
    public RegisterPage run(IndexPage entry){
        return entry.openIndexPage()
                .clickRegisterLink()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setSsn(ssn)
                .setUsername(username)
                .setPassword(password)
                .setRepeatedPassword(password)
                .clickRegisterButton();
    }
}
