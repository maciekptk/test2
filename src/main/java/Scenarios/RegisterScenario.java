package Scenarios;

import Pages.IndexPage;
import Pages.RegisterPage;

import java.util.Random;

public class RegisterScenario implements Scenario<IndexPage, RegisterPage> {

    Random rg = new Random();
    int randomInt = rg.nextInt(1000);

    String firstName = "John";
    String lastName = "Wayne";
    String street = "Main Street 10";
    String city = "Los Angeles";
    String state = "California";
    String zipCode = "90002";
    String ssnTemplate = "AABB";
    String usernameTemplate = "johnwayne";
    String password = "asdfzxcv";
    String username = usernameTemplate + randomInt;
    String ssn = ssnTemplate + randomInt;

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
