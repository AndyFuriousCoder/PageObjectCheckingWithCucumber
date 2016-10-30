package testCode;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import pageObjects.CheckBoxElement;
import pageObjects.LoginElement;
import pageObjects.RadioButtonElement;

@CucumberOptions(features = "src/test/resourses/cucumber.feature")

public class PageObjectCheckingTest extends AbstractTestNGCucumberTests {


    private WebDriver driver; //used WebDriver
    private LoginElement loginElement;
    private CheckBoxElement checkBoxElement;
    private RadioButtonElement radioButtonElement;

   @Before
    public void setUp()
    {
       driver = SetUp.getWebdriver();
    }

    @Given("I am have login object")
    public void getLoginObjectTest()
    {
        loginElement = new LoginElement(driver);
    }

    @When("check Some quantity of pairs Login: \\\"(.*)\\\" and Password: \\\"(.*)\\\"")
    public void loginTest(String userName, String password)
    {
        loginElement.authorize(userName, password);
    }

    @Then("having Result: \\\"(.*)\\\" of authorizing with different logins and passwords")
    public void checkingTest(boolean statement)
    {
        loginElement.checkAuthorizing(statement);
    }


    @Given("I am have page with checkboxes")
    public void goingToPage()
    {
        LoginElement.toIndex8Page(driver);
    }

    @When("I have checkboxes value: \\\"(.*)\\\"")
    public void testingCheckBoxElements(String checkBoxValue)
    {
        //check checkboxes using page object CheckBoxElement
       checkBoxElement = new CheckBoxElement(driver, checkBoxValue);
    }

    @Then("check this checkbox")
    public void checkCheckBoxElement()
    {
        checkBoxElement.check();
    }

    @Given("I am have page with radiobuttons")
    public void goingToPage1()
    {
        LoginElement.toIndex8Page(driver);
    }

    @When("I have radiobuttons value: \\\"(.*)\\\"")
    public void testingRadioButtonsElements(String radioButtonValue)
    {
        //check radioButton using page object RadioButtonElement
       radioButtonElement = new RadioButtonElement(driver, radioButtonValue);
    }

    @Then("check this radiobutton")
    public void checkRadioButtonElement()
    {
        radioButtonElement.check();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
