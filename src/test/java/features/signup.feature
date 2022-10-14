#Author: Krishna Rao
@conduit
Feature: Signup to Conduit app

  Background: Get the random username and email
  Given generate random username and email

  @signup
  Scenario: sign up
    Given User is on Conduit app
    And I will verify conduit title
    When I will click on sign up link
    And I will verify sign up page displayed
    When I will enter Username, Email, Password and click on sign up
    Then I will verify sign up successful
