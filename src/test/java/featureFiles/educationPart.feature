Feature: Education Part Tests

  Background: Successful login in to basqar
    Given I navigate to basqar
    When I try to login using username and password
    Then I am logged in

  Scenario: 3.5a. Create a SubjectCategory
    Given I navigate to "subject categories" screen in Education
    And "New Category" entity doesn't exist in table
    When I create a "New Category" category with "c1" code
    Then "Subject Category" is successfully "created"

  Scenario: 3.6a. Create a Subject
    Given I navigate to "subjects" screen in Education
    And "New Subject" entity doesn't exist in table
    When I create a "New Subject" subject with "c1" code in "New Category"
    Then "Subject" is successfully "created"

  Scenario: 3.7. Remove the category negative test.
    Given I navigate to "subject categories" screen in Education
    When I get the error message when I delete "New Category" country

  Scenario: 3.6b. Delete a Subject
    Given I navigate to "subjects" screen in Education
    When I delete "New Subject" item
    Then "Subject" is successfully "deleted"
    Then Table doesn't contain the entity by name "New Subject"

  Scenario: 3.5b. Delete a SubjectCategory
    Given I navigate to "subject categories" screen in Education
    When I delete "New Category" item
    Then "Subject Category" is successfully "deleted"
    Then Table doesn't contain the entity by name "New Category"



