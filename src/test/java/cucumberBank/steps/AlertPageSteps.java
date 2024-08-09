package cucumberBank.steps;

import cucumberBank.pages.AlertSettingsPage;
import cucumberBank.pages.AlertsPage;
import cucumberBank.pages.MainPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertPageSteps {

    public MainPage mainPage = new MainPage();
    public AlertsPage alertsPage = new AlertsPage();
    public AlertSettingsPage alertSettingsPage = new AlertSettingsPage();

    String dateFromAlerts = "6/20/2024";




    @Then("I should see the result date")
    public void iShouldSeeTheResultDate() {
        assertEquals(dateFromAlerts, alertsPage.getTextFromTable());
    }

    @And("I go to alerts setting page")
    public void iGoToAlertsSettingPage() {
        mainPage.goToAlertsSettingsPage();
    }

    @When("I set a toggle email check box")
    public void iSetAToggleEmailCheckBox() {
        alertSettingsPage.setToggleAndEmailCheckBox();
    }

    @Then("I proof if a toggle and check box is enabled")
    public void iProofIfAToggleAndCheckBoxIsEnabled() {
        assertTrue(alertSettingsPage.togglerDeducted.isEnabled());
        assertTrue(alertSettingsPage.checkBox.isEnabled());
    }

    @When("I set a low balance {string}")
    public void iSetALowBalanceAmount(String balance) {
        alertSettingsPage.changeLowBalance(balance);
    }

    @Then("I proof if a low balance toggle and check box is enabled")
    public void iProofIfALowBalanceToggleAndCheckBoxIsEnabled() {
        assertTrue(alertSettingsPage.lowBalanceCheckBox.isEnabled());
    }
}
