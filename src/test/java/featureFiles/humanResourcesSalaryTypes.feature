Feature: Human Resources Salary Types Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.9b.1 Create a Salary Types
    Given I navigate to "salary types" screen in Human Resources
    And "Salary Type" doesn't exist in "Type 3" table
    When I create a "Salary Type" as "Administrator" role
    Then "Salary Type" is successfully "created"

  Scenario: 3.9b.2 Edit the Salary Types
    Given I navigate to "salary types" screen in Human Resources
    And "New Salary Type" doesn't exist in "Type 3" table
    When I edit  "Salary Type" to "New Salary Type" in "Type 3" table
    Then "Salary Type" is successfully "updated"

  Scenario: 3.9b.3 Delete the Salary Types
    Given I navigate to "salary types" screen in Human Resources
    When I delete "New Salary Type" item from "Type 3" table
    Then "Salary Type" is successfully "deleted"
