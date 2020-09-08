Feature: Human Resources Salary Constants Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.10b.1 Create a Salary Constants
    Given I navigate to "salary constants" screen in Human Resources
    And "Salary Constant" doesn't exist in "Type 4" table
    When I create a "Salary Constant" salary constant
      | Valid From |  09/18/2020 |
      | Key        |  zrt        |
      | Value      |  123        |
    Then "Salary Constant" is successfully "created"

  Scenario: 3.10b.2 Edit the Salary Constants
    Given I navigate to "salary constants" screen in Human Resources
    And "New Salary Constant" doesn't exist in "Type 4" table
    When I edit  "Salary Constant" to "New Salary Constant" in "Type 4" table
    Then "Salary Constant" is successfully "updated"

  Scenario: 3.10b.3 Delete the Salary Constants
    Given I navigate to "salary constants" screen in Human Resources
    When I delete "New Salary Constant" item from "Type 4" table
    Then "Salary Constant" is successfully "deleted"

