@tag
Feature: Login Page Automation EC

@UnitTesting
Scenario: Login with valid credentials
Given User is on Login Page
When User enters valid username and password
And Click login Button
Then User should be navigated to Connect Page
And Close the browser