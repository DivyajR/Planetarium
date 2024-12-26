package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.revature.TestRunner.homePage;
import static com.revature.TestRunner.wait;

public class AddPlanetsSteps {

    @When("the user selects to add a Planet")
    public void the_user_selects_to_add_a_Planet() {
        homePage.selectType("planet");
    }

    @When("the user provides a valid name")
    public void the_user_provides_a_valid_name() {
        homePage.enterPlanetName("jupiter");
    }

    @When("the user provides a valid file type")
    public void the_user_provides_a_valid_file_type() {
        homePage.uploadPlanetImage("C:\\Users\\drija\\Desktop\\Revature\\Example-Test-Suite\\src\\test\\resources\\Celestial-Images\\jupiter.jpg");
    }


    @When("the user provides Planet Name {string}")
    public void the_user_provides_Planet_Name(String string) {
        homePage.enterPlanetName(string);
    }

    @When("the user provides File Type {string}")
    public void the_user_provides_File_Type(String string) {
        homePage.uploadPlanetImage("C:\\Users\\drija\\Desktop\\Revature\\Example-Test-Suite\\src\\test\\resources\\Celestial-Images\\" + string);
    }

    @When("the table should show the added planet")
    public void the_table_should_show_the_added_planet() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celestialTable")));
        String planetNameToCheck = "jupiter";
        boolean isPlanetPresent = homePage.isPlanetInTable(planetNameToCheck);
        Assert.assertTrue("The table does not show the added planet: " + planetNameToCheck, isPlanetPresent);

    }


    @When("the table should not show the added planet {string}")
    public void the_table_should_not_show_the_added_planet(String string) {
        String planetNameToCheck = string;
        boolean planetFound = TestRunner.homePage.isPlanetInTable(planetNameToCheck);
        Assert.assertFalse("Planet was found in the table", planetFound);
    }


}
