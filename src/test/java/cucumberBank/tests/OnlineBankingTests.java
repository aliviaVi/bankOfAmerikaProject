package cucumberBank.tests;



import cucumberBank.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class OnlineBankingTests extends BaseTest {

    @Test
    @Epic("Web Interface")
    @Story("Aletrs")
    @Description("checked the first text in alerts list ")
    public void alertHistoryTest() {
        assertEquals(new MainPage()
                        .cookieWeg()
                        .goToalertsPage()
                        .getTextFromTable(),
                "6/6/2024");
    }

    @Test
//    @Epic("Web Interface")
//    @Story("Aletrs Settings")
//    @Description("checked the toggle in Alerts Settings ")
    public void alertSettingsTest() {
     MainPage mainPage =  new MainPage();
     mainPage.cookieWeg();
        AlertsPage alertsPage = mainPage.goToalertsPage();
        AlertSettingsPage alertSettingsPage = alertsPage.goToAlertsSettingsPage();
        alertSettingsPage.setToggleAndEmailCheckBox();
        WebElement togglerDeducted = alertSettingsPage.togglerDeducted;
      //  WebElement element = alertSettingsPage.listsOfEmailInputBox.get(0);
        WebElement checkBox = alertSettingsPage.checkBox;
        assertTrue(togglerDeducted.isEnabled());
       // assertTrue(element.isSelected());
        assertTrue(checkBox.isEnabled());


    }

    @Test
//    @Epic("Web Interface")
//    @Story("Offers and deals")
//    @Description("checked special offers for customer")
    public void offersAndDealsTextTest() {
        MainPage mainPage = new MainPage();
        assertEquals(mainPage
                        .cookieWeg()
                        .goToAccountOverviewPage()
                        .getTextFromOffersAndDealsButton(),
                "Because you're a valued customer, we've selected some special offers just for you.");
    }

    @Test
//    @Epic("Web Interface")
//    @Story("Transfer between customer accounts")
//    @Description("made a transfer between firsts accounts")
    public void transferBetweenAccountsTest() {
        MainPage mainPage = new MainPage();
        assertEquals(mainPage
                        .cookieWeg()
                        .goToTransferDashboardPage()
                        .toMakeTransferPage()
                        .makeTransfer()
                        .clickTransfer()
                        .getTextSuccess(),
                "Your transfer is confirmed.");

    }

    @Test
//    @Epic("Web Interface")
//    @Story("Account")
//    @Description("checked a customer's number of accounts")
    public void checkOfMyAccountsTest() {
        assertEquals(new MainPage()
                        .cookieWeg()
                        .goToAccountOverviewPage()
                        .getNumbersOfCards(),
                4);
    }

   // @Test
//    @Epic("Mobile web interface")
//    @Story("mobile Banking")
//    @Description("checked a login possibility throw mobile interface")
  /*  public void mobileBankingAppTest() {
        MobileAppSimulator mobileAppSimulator = new MainPage().cookieWeg().goToMobileBanking().goToMobileAppSimulator();
        mobileAppSimulator.mobileAppLogIn();
        assertEquals(mobileAppSimulator.getHelloTextFromBankingApp(), "Hello, Robin\nPreferred Rewards Platinum Member");
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());

    }*/

    @Test
//    @Epic("Web interface")
//    @Story("Security")
//    @Description("checked a possibility to change password")
    public void changePassword() {
        AccountsOverviewPage accountsOverviewPage = new MainPage().cookieWeg().goToAccountOverviewPage();
        accountsOverviewPage.upDate();
        SecurityDashboardPage securityDashboardPage = accountsOverviewPage.goToChangePassword();
        securityDashboardPage.changePassword();
        securityDashboardPage.submitNewPassword();
        assertEquals(securityDashboardPage.getText(), "Your passcode has been changed.");
        //TO DO clear about this result
        assertTrue(securityDashboardPage.slideBarChangePasscode.isEnabled());
    }
}
