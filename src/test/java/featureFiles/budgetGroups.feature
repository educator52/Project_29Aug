Feature: Budget Budget Groups Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.11a.1 Create a Budget Groups
    Given I navigate to "budget groups" screen in Budget
    And "Budget Group" doesn't exist in "Type 2" table
    When I create a "Budget Group" in budget groups
    | Start Date  | 09/18/2020 |
    | End Date    | 10/18/2020 |
    Then "Budget Group" is successfully "created"

  Scenario: 3.11a.2 Edit the Budget Groups
    Given I navigate to "budget groups" screen in Budget
    And "New Budget Group" doesn't exist in "Type 2" table
    When I edit  "Budget Group" to "New Budget Group" in "Type 5" table
    Then "Budget Group" is successfully "updated"

  Scenario: 3.11a.3 Delete the Budget Groups
    Given I navigate to "budget groups" screen in Budget
    When I delete "New Budget Group" item from "Type 2" table
    Then "Budget Group" is successfully "deleted"

