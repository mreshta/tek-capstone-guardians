@Regression
Feature: login

  Background: 
    Given User is on retail website
    When User click on Sign in option

  @login
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'Alpha3@gmail.com' and password 'Alpha123$'
    And User click on login button
    Then User should be logged in into Account

  @createNewAccount
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name    | email                 | password     | confirmPassword |
      | mohamed | mohamed2009@gmail.com | Mohamed1991@ | Mohamed1991@    |
    And User click on SignUp button
    Then Verify user account is created
