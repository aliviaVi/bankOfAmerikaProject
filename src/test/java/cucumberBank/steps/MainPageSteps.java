package cucumberBank.steps;

import cucumberBank.pages.AccountsOverviewPage;
import cucumberBank.pages.MainPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static cucumberBank.context.TestContext.scenario;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageSteps {

    public AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage();

    @When("I click on special offers and deals tab")
    public void clickOnSpecialOffersTab() {
        accountsOverviewPage.clickOnOffersAndDealsBtn();
    }

    @Then("I should see the result text")
    public void userShouldSeeTheTextFromOffersAndDealsTab() {
        assertEquals("Because you're a valued customer, we've selected some special offers just for you.",
                accountsOverviewPage.getTextFromOffersAndDealsButton());
    }
}
