package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.revature.TestRunner.homePage;

public class AddMoonsSteps {
    @When("the user selects to add a Moon")
    public void the_user_selects_to_add_a_Moon() {
        homePage.selectType("moon");
    }

    @When("the user provides a valid moon name")
    public void the_user_provides_a_valid_moon_name() {
        homePage.enterMoonName("Moon2");
    }

    @When("the user provides a valid owning planet")
    public void the_user_provides_a_valid_owning_planet() {
        homePage.enterOwningPlanetId("1");
    }

    @When("the user provides a valid moon file type")
    public void the_user_provides_a_valid_moon_file_type() {
        homePage.uploadMoonImage("C:\\Users\\drija\\Desktop\\Revature\\Example-Test-Suite\\src\\test\\resources\\Celestial-Images\\Moon.jpg");
    }

    @When("the user provides Moon Name {string}")
    public void the_user_provides_Moon_Name(String string) {
        homePage.enterMoonName(string);
    }

    @When("the user provides Owning Planet {string}")
    public void the_user_provides_Owning_Planet(String string) {
        homePage.enterOwningPlanetId(string);
    }

    @When("the user provides File Type moon {string}")
    public void the_user_provides_File_Type_moon(String string) {
        homePage.uploadMoonImage("C:\\Users\\drija\\Desktop\\Revature\\Example-Test-Suite\\src\\test\\resources\\Celestial-Images\\" + string);

    }

    @When("the table should show the added moon")
    public void the_table_should_show_the_added_moon() {
        String MoonNameToCheck = "Moon2";
        boolean moonFound = TestRunner.homePage.isMoonInTable(MoonNameToCheck);
        Assert.assertTrue("Moon was not found in the table", moonFound);
    }

    @When("the table should show the added moon {string}")
    public void the_table_should_show_the_added_moon(String string) {
        String MoonNameToCheck = string;
        boolean moonFound = TestRunner.homePage.isMoonInTable(MoonNameToCheck);
        Assert.assertTrue("Moon was not found in the table", moonFound);
    }

    @When("the table should not show the added moon {string}")
    public void the_table_should_not_show_the_added_moon(String string) {
        String MoonNameToCheck = string;
        boolean moonFound = TestRunner.homePage.isMoonInTable(MoonNameToCheck);
        Assert.assertFalse("Moon was found in the table", moonFound);
    }


}
