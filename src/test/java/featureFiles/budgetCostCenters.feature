Feature: Budget Cost Centers Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.12.a Create a Cost Centers
    Given I navigate to "cost centers" screen in Budget
    And "Cost Center" doesn't exist in budget groups table
    When I create a "Cost Center" in cost centers
    Then "Cost Center" is successfully "created"

  Scenario: 3.12.b Edit the Cost Centers
    Given I navigate to "cost centers" screen in Budget
    And "New Cost Center" doesn't exist in budget groups table
    When I edit  "Cost Center" to "New Cost Center" in budget groups table
    Then "Cost Center" is successfully "updated"

  Scenario: 3.12.c Delete the Cost Centers
    Given I navigate to "cost centers" screen in Budget
    And "New Cost Center" doesn't exist in budget groups table
    Then "Cost Center" is successfully "deleted"

