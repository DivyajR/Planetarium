
Feature: Remove planets from the Planetarium
  As a user, I want to remove planets from the Planetarium so I can correct my findings.

  Background:
    Given the user is logged in on the home page
    When the user selects to delete a Planet

  Scenario: Successful removal of a planet
    And the user provides a valid Planet name to delete
    And the user clicks the delete button
    Then the table should refresh
    And the planet should be removed
    And the user should stay on the Home page

  Scenario Outline: Failed removal due to invalid Planet name
    And the user provides Planet Name "<Planet Name>" to delete
    And the user clicks the delete button
    Then the user should get a browser alert saying "Invalid planet name"
    And the user should stay on the Home page
    Examples:
    |Planet Name|
    |Pluto      |
    |!!!Venus?  |