
Feature: MobileBankingPage

  @iframe
  Scenario: Open main page and try to login in mobile banking
  test to check text in offers and deals tab
    Given I open a main page
    And I accept cookies
    And I go to the mobile banking app
    When I log in mobile banking
    Then I should see greeting text and mobile banking button is present