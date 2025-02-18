Feature: Add planets to the Planetarium
  As a user I want to add new planets to the Planetarium so I can update my findings

  Background:
    Given the user is logged in on the home page
    When the user selects to add a Planet

  Scenario Outline: Successful addition of a planet
    And the user provides Planet Name "<Planet Name>"
    And the user provides File Type "<File Type>"
    And the user submits the info
    Then the table should refresh
    And the table should show the added planet "<Planet Name>"
    And the user should stay on the Home page
    Examples:
      | Planet Name                         | File Type     |
      | jupiters                            | jupiter.jpg   |
      | earthhhh                            | earth.png     |

  Scenario Outline: Successful addition of a planet without file type
    And the user provides Planet Name "<Planet Name>"
    And the user submits the info
    Then the table should refresh
    And the table should show the added planet "<Planet Name>"
    And the user should stay on the Home page
    Examples:
      | Planet Name                           |
      | A_-A                                  |
      | jupiters                              |
      | earthhhh                              |



  Scenario Outline: Failed addition of a planet
    And the user provides Planet Name "<Planet Name>"
    And the user provides File Type "<File Type>"
    And the user submits the info
    Then the user should get a browser alert saying "<Alert>"
    And the user should stay on the Home page
    And the table should not show the added planet "<Planet Name>"

    Examples:
      | Planet Name                              | File Type     | Alert                  |
      | ReallyLongPlanetName_1234567890123456789 | planet-1.jpg  | Invalid planet name    |
      | #Pluto#                                  | planet-2.jpg  | Invalid planet name    |
      | -VEnus!!!                                | venus.gif     | Invalid planet name    |
      | jupiter2                                 | jupiter.gif   | Invalid File Type      |
      | venus                                    | venus.gif     | Invalid File Type      |


  Scenario Outline: Failed addition of a planet because it already exists
    And the user provides Planet Name "<Planet Name>"
    And the user provides File Type "<File Type>"
    And the user submits the info
    Then the user should get a browser alert saying "<Alert>"
    And the user should stay on the Home page
    Examples:
      | Planet Name                              | File Type     | Alert                  |
      | Earth                                    | planet-2.jpg  | Invalid planet name    |
