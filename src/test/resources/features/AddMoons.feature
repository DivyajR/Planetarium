Feature: Add moons to the Planetarium
  As a user, I want to add new moons to the Planetarium so I can update my findings.

  Background:
    Given the user is logged in on the home page
    When the user selects to add a Moon

  Scenario Outline: Successful addition of a moon with file type
    And the user provides Moon Name "<Moon Name>"
    And the user provides Owning Planet "<Owning Planet>"
    And the user provides File Type moon "<File Type>"
    And the user submits the info
    Then the table should refresh
    And the table should show the added moon "<Moon Name>"
    And the user should stay on the Home page
    Examples:
      | Moon Name   | Owning Planet | File Type     |
      | m--n2       | 2             | moon.jpg      |
      | moon2       | 1             | moon.jpg      |
      | moon3       | 2             | earth.png     |


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
    And the user provides File Type moon "<File Type>"
    And the user submits the info
    Then the user should get a browser alert saying "<Alert>"
    And the table should not show the added moon "<Moon Name>"
    And the user should stay on the Home page
    Examples:
      | Moon Name                             | Owning Planet | File Type | Alert             |
      | ReallyLongMoonName_123456789012345678 | 1             | moon.jpg  | Invalid moon name |
      | Moon                                  | 66            | moon.jpg  | Invalid planet id |
      | ReallyLongMoonName_1234567890123456789| 66            | moon.jpg  | Invalid moon name |
      | Moon2                                 | 1             | Venus.gif | Invalid file type |


  Scenario Outline: Failed addition of a moon because it already exists
    And the user provides Moon Name "<Moon Name>"
    And the user provides Owning Planet "<Owning Planet>"
    And the user provides File Type moon "<File Type>"
    And the user submits the info
    Then the user should get a browser alert saying "<Alert>"
    And the user should stay on the Home page
    Examples:
      | Moon Name                                | Owning Planet | File Type    | Alert              |
      | Luna                                     | 1             | moon.jpg     | Invalid moon name  |
