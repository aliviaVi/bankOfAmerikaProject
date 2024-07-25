package cucumberBank.tests;

import cucumberBank.pages.MainPage;
import cucumberBank.pages.SecurityDashboardPage;
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
        SecurityDashboardPage securityDashboardPage = new MainPage()
                .cookieWeg()
                .goToAccountOverviewPage()
                .goToChangePassword();

        securityDashboardPage.changePassword();


        assertEquals("Your passcode has been changed.", securityDashboardPage.getText());
        //TO DO clear about this result
        assertTrue(securityDashboardPage.slideBarChangePasscode.isEnabled());

        securityDashboardPage.submitNewPassword();
    }
}
