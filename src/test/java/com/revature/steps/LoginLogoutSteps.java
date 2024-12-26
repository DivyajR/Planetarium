package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginLogoutSteps {
    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @When("the user presses the log out button")
    public void the_user_presses_the_log_out_button() {
        TestRunner.homePage.logout();
    }

    @Then("the user should no longer have access to their data")
    public void the_user_should_no_longer_have_access_to_their_data() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Home")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }



}
