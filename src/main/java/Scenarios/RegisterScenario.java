package Scenarios;

import Pages.IndexPage;
import Pages.RegisterPage;

import java.util.Random;

public class RegisterScenario implements Scenario<IndexPage, RegisterPage> {

    //dodac konstruktor!!!


//    Random rg = new Random();
//    int randomInt = rg.nextInt(1000);
//    String firstName = "John";
//    String lastName = "Wayne";
//    String street = "Main Street 10";
//    String city = "Los Angeles";
//    String state = "California";
//    String zipCode = "90002";
//    String ssnTemplate = "AABB";
//    String usernameTemplate = "johnwayne";
//    String password = "asdfzxcv";
//    String username = usernameTemplate + randomInt;
//    String ssn = ssnTemplate + randomInt;

    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    String zipCode;
    String ssnTemplate;
    String usernameTemplate;
    String password;
//    String username = usernameTemplate + randomInt;
//    String ssn = ssnTemplate + randomInt;
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
