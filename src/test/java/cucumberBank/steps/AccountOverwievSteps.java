package cucumberBank.steps;

import cucumberBank.pages.AccountsOverviewPage;
import cucumberBank.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static cucumberBank.context.TestContext.scenario;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountOverwievSteps {

    public MainPage mainPage =new MainPage();
    public AccountsOverviewPage accountsOverviewPage =new AccountsOverviewPage();

    @Given("I open a main page")
    public void i_open_a_main_page() {
        scenario.log("Hello");
    }
    @And("I accept cookies")
    public void acceptCookies(){
        mainPage.cookieWeg();
    }
    @And("I go to the account overview page")
    public void goToAccountOverviewPage(){
        accountsOverviewPage = mainPage.goToAccountOverviewPage();
    }
    @When("I click on alerts tab")
    public void clickOnAlertsTab(){
        accountsOverviewPage.clickOnAlertsTab();
    }

    @Then("I should see the result text")
    public void userShouldSeeTheTextAlertsTabTab(){
        assertEquals("Your Balances Qualify You for Preferred Rewards", accountsOverviewPage.getAlertsText());
    }
}
