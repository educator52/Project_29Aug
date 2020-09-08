Feature: Country Part Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.1a. Create a county
    Given I navigate to "country" screen
    And "NewCountry" entity doesn't exist in table
    When I create a "NewCountry" country
    Then "Country" is successfully "created"

  Scenario: 3.1b. Delete a country
    Given I navigate to "country" screen
    When I delete "NewCountry" item
    Then "Country" is successfully "deleted"
    Then Table doesn't contain the entity by name "NewCountry"

  Scenario: 3.2a. Create a city
    Given I navigate to "cities" screen
    And "NewCity" entity doesn't exist in table
    When I create a "NewCity" city in the "Russia" country.
    Then "City" is successfully "created"

  Scenario: 3.2b. Delete a city
    Given I navigate to "cities" screen
    When I delete "NewCity" item
    Then "City" is successfully "deleted"
    Then Table doesn't contain the entity by name "NewCity"

  Scenario: 3.3a. Create a country and create a city.
    Given I navigate to "country" screen
    And "NewCountry" entity doesn't exist in table
    When I create a "NewCountry" country
    Then "Country" is successfully "created"
    And I click to cities
    When I create a "NewCity" city in the "NewCountry" country.
    Then "City" is successfully "created"

  Scenario: 3.3b. Remove the country negative test.
    Given I navigate to "country" screen
    When I get the error message when I delete "NewCountry" country

  Scenario: 3.3c. Remove the country.
    Given I navigate to "cities" screen
    When I delete "NewCity" item
    Then "City" is successfully "deleted"
    And I click to country
    When I delete "NewCountry" item
    Then "Country" is successfully "deleted"
