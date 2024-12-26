package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement locationSelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id = "deleteInput")
    private WebElement deleteContainerInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement owningPlanetInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "celestialTable")
    private WebElement celestialTable;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public boolean isLogoutButtonVisible() {
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // If the element is not found, return false.
        }
    }
    public void logout(){
        logoutButton.click();
    }

    public void selectType(String type) {
        Select dropdown = new Select(locationSelect);
        dropdown.selectByValue(type);
    }

    public void enterPlanetName(String planetName) {
        planetNameInput.sendKeys(planetName);
    }

    public void uploadPlanetImage(String filePath) {
        planetImageInput.sendKeys(filePath);
    }

    public void submitCreation() {
        submitButton.click();
    }

    public WebElement getCelestialTable() {
        return celestialTable;
    }
    public boolean isPlanetInTable(String planetName) {
        for (int i = 1; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            System.out.println("Row " + i + ": " + row.getText());


            try {
                String rowPlanetName = row.findElement(By.xpath("td[3]")).getText();

                if (rowPlanetName.equals(planetName)) {
                    return true;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return false;
    }

    public void enterMoonName(String moonName) {
        moonNameInput.sendKeys(moonName);
    }

    public void enterOwningPlanetId(String owningPlanetId) {
        owningPlanetInput.sendKeys(owningPlanetId);
    }

    public void uploadMoonImage(String filePath) {
        moonImageInput.sendKeys(filePath);
    }

    public boolean isMoonInTable(String moonName) {
        for (int i = 1; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);

            try {
                String rowMoonName = row.findElement(By.xpath("td[3]")).getText();

                if (rowMoonName.equals(moonName)) {
                    return true;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return false;
    }

    public void enterDeleteName(String deleteName) {
        deleteContainerInput.sendKeys(deleteName);
    }

    public void delete(){
        deleteButton.click();
    }
}









