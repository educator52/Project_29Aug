Feature: Human Resources Salary Modifiers Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.10a.1 Create a Salary Modifiers
    Given I navigate to "salary modifiers" screen in Human Resources
    And "Salary Modifier" doesn't exist in "Type 4" table
    When I create a "Salary Modifier"
    | Variable  | Priority  | Amount  |
    | 123       | 500       | 700     |
    Then "Salary Modifiers" is successfully "created"

  Scenario: 3.10a.2 Edit the Salary Modifiers
    Given I navigate to "salary modifiers" screen in Human Resources
    And "New Salary Modifier" doesn't exist in "Type 4" table
    When I edit  "Salary Modifier" to "New Salary Modifier" in "Type 4" table
    Then "Salary Modifiers" is successfully "updated"

  Scenario: 3.10a.3 Delete the Salary Modifiers
    Given I navigate to "salary modifiers" screen in Human Resources
    When I delete "New Salary Modifier" item from "Type 4" table
    Then "Salary Modifiers" is successfully "deleted"

