package com.tests;

import com.pages.AccountsOverviewPage;
import com.pages.MainPage;
import com.pages.SecurityDashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityDashboardPageTest extends BaseTest {
    @Test
    @Epic("Web interface")
    @Story("Security")
    @Description("checked a possibility to change password")
    public void changePassword() {
        AccountsOverviewPage accountsOverviewPage = new MainPage(context).cookieWeg().goToAccountOverviewPage();
        SecurityDashboardPage securityDashboardPage = accountsOverviewPage.goToChangePassword();
        securityDashboardPage.changePassword();
        securityDashboardPage.submitNewPassword();
        assertEquals(securityDashboardPage.getText(), "Your passcode has been changed.");
        //TO DO clear about this result
        assertTrue(securityDashboardPage.slideBarChangePasscode.isEnabled());
    }
}
