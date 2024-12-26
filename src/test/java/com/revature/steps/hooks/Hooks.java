package com.revature.steps.hooks;

import com.revature.TestRunner;
import com.revature.utility.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Alert;

import static com.revature.TestRunner.driver;

public class Hooks {

    /*
        Instead of manually resetting the test database between
        runs we can use a hook and the setup class to automate
        the database reset process
     */

    @Before
    public void resetDatabase(){
        System.out.println("resetDatabase hook called");
        Setup.resetTestDatabase();
    }

    @Before
    public void handleAlertsBeforeEachScenario() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {

        }
    }

    @After("@view")
    public void logoutAfterCelestialFeature() {
        // Only attempt to logout if the logout button is visible
        if (TestRunner.homePage.isLogoutButtonVisible()) {
            TestRunner.homePage.logout();
        } else {
            System.out.println("User is not logged in, skipping logout.");
        }
    }

}