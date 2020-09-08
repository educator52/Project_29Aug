Feature: Human Resources Position Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.8b.1 Create a position
    Given I navigate to "positions" screen in Human Resources
    And "Position" doesn't exist in "Type 1" table
    When I create a "Position" position with "NP" short name.
    Then "Employee Position" is successfully "created"

  Scenario: 3.8b.2 Edit the position
    Given I navigate to "positions" screen in Human Resources
    And "New Position" doesn't exist in "Type 1" table
    When I edit  "Position" to "New Position" in "Type 1" table
    Then "Employee Position" is successfully "updated"


  Scenario: 3.8b.3 Delete the position
    Given I navigate to "positions" screen in Human Resources
    When I delete "New Position" item from "Type 1" table
    Then "Employee Position" is successfully "deleted"
