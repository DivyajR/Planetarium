Feature: User login and logout
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment.

  Background:
    Given the user is on the login page

  Scenario Outline: Successful login
    When the user provides username "<username>"
    And the user provides password "<password>"
    And the user submits the credentials
    Then the user should be redirected to the home page
    Examples:
      | username  | password          |
      | Batman    | Iamthenight1939   |

  Scenario: Successful logout
    Given the user is logged in on the home page
    When the user presses the log out button
    Then the user should be redirected to the login page
    And the user should no longer have access to their data

  Scenario Outline: Failed login due to invalid credentials
    When the user provides username "<username>"
    And the user provides password "<password>"
    And the user submits the credentials
    Then the user should get a browser alert saying "<expected_result>"
    And the user should stay on the login page
    Examples:
      | username | password          | expected_result       |
      | Batman   | b0Ts              | Invalid credentials   |
      | Robin    | Iamthenight1939   | Invalid credentials   |
      | Robin    | b0Ts              | Invalid credentials   |
