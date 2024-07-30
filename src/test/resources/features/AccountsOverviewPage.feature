
Feature: AccountsOverviewPage

  Scenario: Open main page and check the Alert text into Account overview page
  test to check text in Alerts tab
    Given I open a main page
    And I accept cookies
    And I go to the account overview page
    When I click on alerts tab
    Then I should see the result  alert tab text


  Scenario: Open main page and check number of cards on Account overview page
test the amount of cards on Accounts overview page
    Given I open a main page
    And I accept cookies
    And I go to the account overview page
    When I see a number of cards
    Then I should check an amount of cards