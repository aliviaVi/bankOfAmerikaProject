package cucumberBank.steps;

import cucumberBank.pages.AccountsOverviewPage;
import cucumberBank.pages.SecurityDashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityDashboardPageSteps {

    private SecurityDashboardPage securityDashboardPage = new SecurityDashboardPage();
    private AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage();
    String successMessage = "Your passcode has been changed.";


    @And("I go to the change password page")
    public void goToChangePasswordPage(){
        accountsOverviewPage.goToChangePassword();
    }

    @When("I click th change password")
    public void iClickThChangePassword() {
        securityDashboardPage.changePassword();
    }

    @Then("I should see the result text before submit")
    public void iShouldSeeTheResultTextBeforeSubmit() {
        assertEquals(successMessage, securityDashboardPage.getText());

        securityDashboardPage.submitNewPassword();
    }
}
