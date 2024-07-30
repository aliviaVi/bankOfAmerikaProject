package cucumberBank.steps;

import cucumberBank.pages.MainPage;
import cucumberBank.pages.MobileAppSimulator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileBankingPageSteps {
    private MainPage mainPage = new MainPage();
    private MobileAppSimulator mobileAppSimulator = new MobileAppSimulator();

    String greetingText = "Hello, Robin\nPreferred Rewards Platinum Member";


    @And("I go to the mobile banking app")
    public void goToMobileApp() throws InterruptedException {
        mainPage.goToMobileBanking();

    }

    @When("I log in mobile banking")
    public void iLogInMobileBanking() {
        mobileAppSimulator.mobileAppLogIn();
    }

    @Then("I should see greeting text and mobile banking button is present")
    public void iShouldSeeGreetingTextAndMobileBankingButtonIsPresent() {
        assertEquals(greetingText, mobileAppSimulator.getHelloTextFromBankingApp());
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());
        mainPage.closeWindowAfterAssert();
    }
}
