#Author: Krishna Rao
@conduit
Feature: I want to edit my article
  Given generate random article title

  @login
  Scenario Outline: login to conduit app
    Given User is on Conduit app
    Given user is logged in?
    And I will click on sign in link
    And I will verify sign in page displayed
    When user enters "<email>", "<password>" and clicks on sign in
    And I will verify user logged in

    Examples: 
      | email         | password |
      | elly@test.com | test1234 |

  @edit-article
  Scenario Outline: edit the article
    Given I will click on user pic
    And I will verify user posts page displayed
    And I will verify posts are there
    Then I will click on first article
    And I will verify post details displayed
    Then I will click on edit article button
    When user enters "<about>", "<article_text>", "<tags>" and publish
    Then I will verify article published successfully
    And I will verify article displayed in Global Feed

    Examples: 
      | about   | article_text            | tags     |
      | Testing | Automation is beautiful | cucumber |

  @signout
  Scenario: User Signout from Conduit app
    Given I will click on user pic
    And I will verify user posts page displayed
    When I will click on edit profile settings button
    And I will verify user settings page displayed
    Then I will click on logout button
    And I will verify user logged out
