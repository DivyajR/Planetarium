package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.revature.TestRunner.homePage;
import static com.revature.TestRunner.wait;

public class SharedSteps {


    @Given("the user is logged in on the home page")
    public void the_user_is_logged_in_on_the_home_page() {
        TestRunner.loginPage.setUpLoggedInUser();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("the user should stay on the Home page")
    public void the_user_should_stay_on_the_Home_page() {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }


    @When("the user provides username {string}")
    public void the_user_provides_username(String username) {
        TestRunner.registrationPage.enterUsername(username);
    }
    @When("the user provides password {string}")
    public void the_user_provides_password(String password) {
        TestRunner.registrationPage.enterPassword(password);
    }

    @When("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        TestRunner.registrationPage.clickCreateButton();
    }

    @When("the user submits the info")
    public void the_user_submits_the_info() {
        TestRunner.homePage.submitCreation();
    }


    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }

    @Then("the table should refresh")
    public void the_table_should_refresh() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.id("celestialTable"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celestialTable")));

    }


    @When("the user clicks the delete button")
    public void the_user_clicks_the_delete_button() {
        homePage.delete();
    }

}
