#Author: Krishna Rao
@google
Feature: Google Search

  @google-search
  Scenario: Google Search
    Given user is on google search page "https://www.google.co.in"
    And searches for "selenium bdd framework"
    When user clicks on search button
    Then the results should be displayed and saved in csv file
