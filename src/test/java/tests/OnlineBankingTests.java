package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


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
        MainPage mainPage = new MainPage(context);

       // OlbSimulatorPage olbSimulatorPage = new OlbSimulatorPage(context);
        assertEquals(mainPage
                        .goToAccountOverviewPage()
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
        assertEquals(mobileAppSimulator.getHelloTextFromBankingApp(), "Hello, Robin\nPreferred Rewards Platinum Member");
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());

    }
}
