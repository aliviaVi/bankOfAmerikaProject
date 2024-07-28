@ignored
Feature: SecurityDashboardPage

  Scenario: Open main page and go to the setting page to change the actual password
  test to change actual password
    Given I open a main page
    And I accept cookies
    And I go to the account overview page
    And I go to the change password page
    When I click th change password
    Then I should see the result text before submit

