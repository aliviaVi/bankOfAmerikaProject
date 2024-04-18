package tests;


import org.junit.Test;
import org.junit.jupiter.api.TestInstance;

import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OnlineBankingTests extends BaseTest {

    @Test
    public void alertHistoryTest() {
        //OlbSimulatorPage olbSimulatorPage = new OlbSimulatorPage(context);
        // assertEquals(olbSimulatorPage.alertsClick().getTextFromTable(), "3/7/2024");
        assertEquals(new MainPage(context)
                        .goToalertsPage()
                        .alertsClick()
                        .getTextFromTable(),
                "3/7/2024");
    }

    @Test
    public void offersAndDealsTextTest() {
        OlbSimulatorPage olbSimulatorPage = new OlbSimulatorPage(context);
        assertEquals(olbSimulatorPage
                        .overviewPageClick()
                        .getTextFromOffersAndDealsButton(),
                "Because you're a valued customer, we've selected some special offers just for you.");
    }

    @Test
    public void transferBetweenAccountsTest() {
        MainPage mainPage = new MainPage(context);
        assertEquals(mainPage
                        .goToTransferDashboardPage()
                        .toMakeTransferPage()
                        .makeTransfer()
                        .clickTransfer()
                        .getTextSuccess(),
                "Your transfer is confirmed.");

    }

    @Test
    public void checkOfMyAccountsTest() {
        assertEquals(new MainPage(context)
                        .goToAccountOverviewPage()
                        .getNumbersOfCards(),
                4);
    }

    @Test
    public void mobileBankingAppTest() {
        MobileAppSimulator mobileAppSimulator = new MainPage(context).goToMobileBanking().goToMobileAppSimulator();
        mobileAppSimulator.mobileAppLogIn();
        assertEquals(mobileAppSimulator.getHelloTextFromBankingApp(), "Hello, Robin");
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());

    }
}
