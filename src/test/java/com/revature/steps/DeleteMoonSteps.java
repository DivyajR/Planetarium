package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.revature.TestRunner.homePage;

public class DeleteMoonSteps {

    @When("the user selects to delete a Moon")
    public void the_user_selects_to_delete_a_Moon() {
        homePage.selectType("moon");
    }

    @When("the user provides a valid moon name to delete")
    public void the_user_provides_a_valid_moon_name_to_delete() {
        homePage.enterDeleteName("Luna");
    }

    @Then("the moon should be removed")
    public void the_moon_should_be_removed() {
        String moonNameToCheck = "Luna";
        boolean moonFound = TestRunner.homePage.isMoonInTable(moonNameToCheck);
        Assert.assertFalse("Moon was found in the table", moonFound);
    }

    @When("the user provides Moon Name {string} to delete")
    public void the_user_provides_Moon_Name_to_delete(String string) {
        homePage.enterDeleteName(string);
    }


}
