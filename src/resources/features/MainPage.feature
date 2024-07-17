Feature: MainPage

  Scenario: Open main page
  test to check text in offers and deals tab
    Given I open a main page
    And I accept cookies
    And go to the account overview page
    When I click on special offers and deals tab
    Then I should see the result text
