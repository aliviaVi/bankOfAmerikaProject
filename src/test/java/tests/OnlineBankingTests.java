package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class OnlineBankingTests extends BaseTest {

    @Test
    @Epic("Web Interface")
    @Story("Aletrs")
    @Description("checked the first text in alerts list ")
    public void alertHistoryTest() {
        assertEquals(new MainPage(context)
                        .goToalertsPage()
                        .getTextFromTable(),
                "3/8/2024");
    }

    @Test
    @Epic("Web Interface")
    @Story("Offers and deals")
    @Description("checked special offers for customer")
    public void offersAndDealsTextTest() {
        MainPage mainPage = new MainPage(context);
        assertEquals(mainPage
                        .goToAccountOverviewPage()
                        .getTextFromOffersAndDealsButton(),
                "Because you're a valued customer, we've selected some special offers just for you.");
    }

    @Test
    @Epic("Web Interface")
    @Story("Transfer between customer accounts")
    @Description("made a transfer between firsts accounts")
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
    @Epic("Web Interface")
    @Story("Account")
    @Description("checked a customer's number of accounts")
    public void checkOfMyAccountsTest() {
        assertEquals(new MainPage(context)
                        .goToAccountOverviewPage()
                        .getNumbersOfCards(),
                4);
    }

    @Test
    @Epic("Mobile web interface")
    @Story("mobile Banking")
    @Description("checked a login possibility throw mobile interface")
    public void mobileBankingAppTest() {
        MobileAppSimulator mobileAppSimulator = new MainPage(context).goToMobileBanking().goToMobileAppSimulator();
        mobileAppSimulator.mobileAppLogIn();
        assertEquals(mobileAppSimulator.getHelloTextFromBankingApp(), "Hello, Robin\nPreferred Rewards Platinum Member");
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());

    }

    @Test
    @Epic("Web interface")
    @Story("Security")
    @Description("checked a possibility to change password")
    public void changePassword() {
        AccountsOverviewPage accountsOverviewPage = new MainPage(context).goToAccountOverviewPage();
        accountsOverviewPage.upDate();
        SecurityDashboardPage securityDashboardPage = accountsOverviewPage.goToChangePassword();
        securityDashboardPage.changePassword();
        securityDashboardPage.submitNewPassword();
        assertEquals(securityDashboardPage.getText(), "Your passcode has been changed.");
        //TO DO clear about this result
        assertTrue(securityDashboardPage.slideBarChangePasscode.isEnabled());
    }
}
