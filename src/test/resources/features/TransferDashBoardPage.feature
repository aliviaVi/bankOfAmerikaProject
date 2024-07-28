@ignored
Feature: TransferDashBoardPage


  @positive
  Scenario Outline: Open main page, go to transfer page between accounts.

    Given I open a main page
    And I accept cookies
    And I go to the transfer dashboard page
    And I go the page make transfer
    When I made a transfer'<amount>'
    Then I should see the success text message

    Examples:
      | amount |
      | 200    |
      | 500    |
      | 12698  |

