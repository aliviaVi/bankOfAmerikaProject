package com.tests;

import com.pages.AccountsOverviewPage;
import com.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountoverwievPageTests extends BaseTest {
    @Test
    @Epic("Web Interface")
    @Story("Account overview")
    @Description("check the popover in alerts tab")
    public void popoverInMainPage() {
        MainPage mainPage = new MainPage(context);
        mainPage.cookieWeg();
        AccountsOverviewPage accountsOverviewPage = mainPage.goToAccountOverviewPage();
        accountsOverviewPage.goToCheckAlertsText();

        assertEquals("Your Balances Qualify You for Preferred Rewards", accountsOverviewPage.textInPopOver.getText());
        accountsOverviewPage.closePopOverBtn.click();

    }
    @Test
   @Epic("Web Interface")
    @Story("Account")
    @Description("checked a customer's number of accounts")
    public void checkOfMyAccountsTest() {
        assertEquals(new MainPage(context)
                        .cookieWeg()
                        .goToAccountOverviewPage()
                        .getNumbersOfCards(),
                4);
    }
}
