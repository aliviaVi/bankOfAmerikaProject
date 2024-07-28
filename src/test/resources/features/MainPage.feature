@ignored
Feature: MainPage

  Scenario: Open main page and check the text into Account overview page
  test to check text in offers and deals tab
    Given I open a main page
    And I accept cookies
    And I go to the account overview page
    When I click on special offers and deals tab
    Then I should see the result text


