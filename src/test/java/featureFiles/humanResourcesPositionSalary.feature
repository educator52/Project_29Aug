Feature: Human Resources Position Salary Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.8a.1 Create a position Salary
    Given I navigate to "position salary" screen in Human Resources
    And "Position Salary" doesn't exist in "Type 2" table
    When I create a "Position Salary" position salary
    Then "Position" is successfully "created"

  Scenario: 3.8a.2 Edit the position Salary
    Given I navigate to "position salary" screen in Human Resources
    And "New Position Salary" doesn't exist in "Type 2" table
    When I edit  "Position Salary" to "New Position Salary" in "Type 2" table
    Then "Position" is successfully "updated"

  Scenario: 3.8a.3 Delete the position Salary
    Given I navigate to "position salary" screen in Human Resources
    When I delete "New Position Salary" item from "Type 2" table
    Then "Position" is successfully "deleted"
    Then Table doesn't contain "New Position Salary"
