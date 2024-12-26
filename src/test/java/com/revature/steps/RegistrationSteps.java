package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSteps {

    @Given("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestRunner.loginPage.clickRegistrationLink();
    }

    @When("the user provides a valid username")
    public void the_user_provides_a_valid_username() {
        TestRunner.registrationPage.enterUsername("Super_man-2001");
    }
    @When("the user provides a valid password")
    public void the_user_provides_a_valid_password() {
        TestRunner.registrationPage.enterPassword("Krypton-was_2000");
    }



    @Then("the user should stay on the registration page")
    public void the_user_should_stay_on_the_registration_page() {
        Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
    }
}