package cucumberBank.steps;

import cucumberBank.pages.TransferDashBoardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferDashBoardPageSteps {

    public TransferDashBoardPage transferDashBoardPage = new TransferDashBoardPage();
    String successMessage = "Your transfer is confirmed.";

    @And("I go the page make transfer")
    public void goToMakeTransferPage() {
        transferDashBoardPage.toMakeTransferPage();
    }

    @When("I made a transfer{string}")
    public void makeATransfer(String amount) {
        transferDashBoardPage.makeTransfer(amount);
        transferDashBoardPage.clickTransfer();
    }

    @Then("I should see the success text message")
    public void getSuccessText() {
        assertEquals(successMessage, transferDashBoardPage.getTextSuccess());
    }


}
