package Pages;

import Assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends MainPage {
    public RegisterAssertion registerAssertion;

    @FindBy(css = "[name='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[name='customer.address.street']")
    private WebElement streetInput;

    @FindBy(css = "[name='customer.address.city']")
    private WebElement cityInput;

    @FindBy(css = "[name='customer.address.state']")
    private WebElement stateInput;

    @FindBy(css = "[name='customer.address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "[name='customer.ssn']")
    private WebElement ssnInput;

    @FindBy(css = "[name='customer.username']")
    private WebElement usernameInput;

    @FindBy(css = "[name='customer.password']")
    private WebElement passwordInput;

    @FindBy(css = "[name='repeatedPassword']")
    private WebElement repeatedPasswordInput;

    @FindBy(css = "[value='Register']")
    private WebElement registerButton;

    @FindBy(css = "[href$='openaccount.htm']")
    private WebElement openNewAccountLink;

    @FindBy(css = "[href$='transfer.htm']")
    private WebElement tranferFundsLink;

    @FindBy(css = ".home")
    private WebElement homeButton;

    private String url;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegisterAssertion(driver);
    }

    public RegisterPage setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage setStreet(String street){
        streetInput.sendKeys(street);
        return this;
    }

    public RegisterPage setCity(String city){
        cityInput.sendKeys(city);
        return this;
    }

    public RegisterPage setState(String state){
        stateInput.sendKeys(state);
        return this;
    }

    public RegisterPage setZipCode(String zipCode){
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegisterPage setSsn(String ssn){
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegisterPage setUsername(String username){
        usernameInput.sendKeys(username);
        return this;
    }

    public RegisterPage setPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage setRepeatedPassword(String password){
        repeatedPasswordInput.sendKeys(password);
        return this;
    }

    public RegisterPage clickRegisterButton(){
        registerButton.click();
        return this;
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        openNewAccountLink.click();
        return new OpenNewAccountPage(driver);
    }

    public TransferPage clickTransferFundsLink(){
        tranferFundsLink.click();
        return new TransferPage(driver);
    }

    public IndexPage clickHomeButton(){
        homeButton.click();
        return new IndexPage(driver, url);
    }
}
