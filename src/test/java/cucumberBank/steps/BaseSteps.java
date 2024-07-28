package cucumberBank.steps;

import cucumberBank.pages.AccountsOverviewPage;
import cucumberBank.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static cucumberBank.context.TestContext.scenario;

public class BaseSteps {
    public MainPage mainPage =new MainPage();


    @Given("I open a main page")
    public void i_open_a_main_page() {
        scenario.log("Hello");
    }
    @And("I accept cookies")
    public void acceptCookies(){
        mainPage.cookieWeg();
    }
    @And("I go to the account overview page")
    public void goToAccountOverviewPage()  {
        mainPage.goToAccountOverviewPage();
    }
    @And("I go to the transfer dashboard page")
    public void goToTransferDashboardPage(){
        mainPage.goToTransferDashboardPage();
    }

    @When("I go the alerts page")
    public void goFromMainToAlertsPage(){
        mainPage.goToalertsPage();
    }
}
