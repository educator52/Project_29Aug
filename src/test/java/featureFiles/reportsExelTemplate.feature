Feature: Reports Exel Template Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.9a.1  Create an Excel Template
    Given I navigate to exel template screen
    And "Template" entity doesn't exist in table
    When I create a "Template" template
    Then "Budget Excel Template" is successfully "created"

  Scenario: 3.8b.2 Edit the Excel Template
    Given I navigate to exel template screen
    And "New Template" entity doesn't exist in table
    When I edit  "Template" to "New Template" in "Type 6" table
    Then "Budget Excel Template" is successfully "updated"


  Scenario: 3.8b.3 Delete the Excel Template
    Given I navigate to exel template screen
    When I delete "New Template" item from "Type 1" table
    Then "Budget Excel Template" is successfully "deleted"
    Then Table doesn't contain the entity by name "New Template"
