#Author: Krishna Rao
@conduit
Feature: Create New Article

  Background: Get the random Article Title
    Given generate random article title

  @login
  Scenario Outline: Login to conduit app
    Given User is on Conduit app
    And I will click on sign in link
    And I will verify sign in page displayed
    When user enters "<email>", "<password>" and clicks on sign in
    And I will verify user logged in

    Examples: 
      | email         | password |
      | elly@test.com | test1234 |

  @new-article
  Scenario Outline: Create a new article
    Given User clicks on new article link
    And I will verify new article page displayed
    When user enters "<about>", "<article_text>", "<tags>" and publish
    Then I will verify article published successfully
    And I will verify article displayed in Global Feed

    Examples: 
      | about      | article_text                 | tags     |
      | automation | Selenium cucumber automation | selenium |

  @logout
  Scenario: Logout from conduit app
    Given I will click on user pic
    And I will verify user posts page displayed
    When I will click on edit profile settings button
    And I will verify user settings page displayed
    Then I will click on logout button
    And I will verify user logged out
