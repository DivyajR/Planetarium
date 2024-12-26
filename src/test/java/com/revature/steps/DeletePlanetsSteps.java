package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.revature.TestRunner.homePage;

public class DeletePlanetsSteps {

    @When("the user selects to delete a Planet")
    public void the_user_selects_to_delete_a_Planet() {
        homePage.selectType("planet");
    }

    @When("the user provides a valid Planet name to delete")
    public void the_user_provides_a_valid_Planet_name_to_delete() {
        homePage.enterDeleteName("Earth");
    }


    @Then("the planet should be removed")
    public void the_planet_should_be_removed() {
        String planetNameToCheck = "Earth";
        boolean planetFound = TestRunner.homePage.isPlanetInTable(planetNameToCheck);
        Assert.assertFalse("Planet was found in the table", planetFound);
    }

    @When("the user provides Planet Name {string} to delete")
    public void the_user_provides_Planet_Name_to_delete(String string) {
        homePage.enterDeleteName(string);
    }




}
