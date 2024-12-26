@tag
Feature: Data-Driven Testing

@ddtTesting
Scenario: Validate login with multiple credentials
  Given I navigate to the login page
  When I test multiple login credentials
  Then I verify the login results