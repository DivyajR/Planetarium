Feature: Add moons to the Planetarium
  As a user, I want to add new moons to the Planetarium so I can update my findings.

  Background:
    Given the user is logged in on the home page
    When the user selects to add a Moon

  Scenario: Successful addition of a moon with file type
    And the user provides a valid moon name
    And the user provides a valid owning planet
    And the user provides a valid moon file type
    And the user submits the info
    Then the table should refresh
    And the table should show the added moon
    And the user should stay on the Home page

  Scenario: Successful addition of a moon without file type
    And the user provides a valid moon name
    And the user provides a valid owning planet
    And the user submits the info
    Then the table should refresh
    And the table should show the added moon
    And the user should stay on the Home page


  Scenario Outline: Failed addition of a moon due to invalid attributes
    And the user provides Moon Name "<Moon Name>"
    And the user provides Owning Planet "<Owning Planet>"
    And the user submits the info
    Then the user should get a browser alert saying "<alert>"
    And the table should not show the added moon "<Moon Name>"
    And the user should stay on the Home page
    Examples:
      | Moon Name                                 | Owning Planet   | alert                        |
      | ReallyLongMoonName_1234567890123456789    |1           | Invalid moon name    |
      | Moon                                      |66           | Invalid planet id   |
      | ReallyLongMoonName_1234567890123456789    |66           | Invalid moon name    |

  Scenario Outline: Failed addition of a planet due to invalid file type
    And the user provides Moon Name "<Moon Name>"
    And the user provides Owning Planet "<Owning Planet>"
    And the user provides File Type moon "<File Type>"
    And the user submits the info
    And the user should stay on the Home page
    And the table should not show the added moon "<Moon Name>"
    Examples:
      | Moon Name    | Owning Planet   | File Type      |
      |Moon2         |1            |Venus.gif           |

