Feature: Remove moons from the Planetarium
  As a user, I want to remove moons from the Planetarium so I can correct my findings.

  Background:
    Given the user is logged in on the home page
    When the user selects to delete a Moon

  Scenario: Successful removal of a moon
    And the user provides a valid moon name to delete
    And the user clicks the delete button
    Then the table should refresh
    And the moon should be removed
    And the user should stay on the Home page

  Scenario Outline: Failed removal due to invalid Moon name
    And the user provides Moon Name "<Moon Name>" to delete
    And the user clicks the delete button
    Then the user should get a browser alert saying "Invalid moon name"
    And the user should stay on the Home page
    Examples:
      |Moon Name|
      |LUNAR      |
      |!!!MOON?  |