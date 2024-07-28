package cucumberBank.steps;

import cucumberBank.pages.AccountsOverviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountsOverviewPageSteps {


    public AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage();

    @When("I click on alerts tab")
    public void clickOnAlertsTab() throws InterruptedException {
        accountsOverviewPage.clickOnAlertsTab();
    }

    @Then("I should see the result  alert tab text")
    public void userShouldSeeTheTextAlertsTabTab(){
        assertEquals("Your Balances Qualify You for Preferred Rewards", accountsOverviewPage.getAlertsText());
    }
    @When("I see a number of cards")
    public void findAllCardsOnPage(){
        int numbersOfCards = accountsOverviewPage.getNumbersOfCards();
    }
    @Then("I should check an amount of cards")
    public void checkTheCountOfCards(){
        assertEquals(4,accountsOverviewPage.getNumbersOfCards());
    }
}
