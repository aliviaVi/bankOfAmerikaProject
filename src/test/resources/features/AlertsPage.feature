
Feature: AlertsPage


  Scenario: Open main page and go to the alerts page

    Given I open a main page
    And I accept cookies
    When I go the alerts page
    Then I should see the result date


    Scenario: On alerts page change alerts way. put an email and setting toggle.
      Given I open a main page
      And I accept cookies
      And I go the alerts page
      And I go to alerts setting page
      When I set a toggle email check box
      Then I proof if a toggle and check box is enabled

  Scenario Outline: On alerts settings page change the low balance.

    Given I open a main page
    And I accept cookies
    And I go the alerts page
    And I go to alerts setting page
    When I set a low balance '<amount>'
    Then I proof if a low balance toggle and check box is enabled

    Examples:
      | amount |
      | 300   |
      | 50    |
      | 685490685403 |