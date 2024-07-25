Feature: AccountOverwievPage

  Scenario: Open main page and check the Alert text into Account overview page
  test to check text in Alerts tab
    Given I open a main page
    And I accept cookies
    And I go to the account overview page
    When I click on alerts tab
    Then I should see the result text