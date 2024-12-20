@tag
Feature: User Registration

@UnitTesting1
Scenario: Successful registration
    Given I am on the registration page
    When I fill in valid details
    Then I should successfully registered an account