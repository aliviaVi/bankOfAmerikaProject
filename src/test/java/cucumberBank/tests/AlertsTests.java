package cucumberBank.tests;

import cucumberBank.pages.AlertSettingsPage;
import cucumberBank.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTests  extends BaseTest {
    @Test
    @Epic("Web Interface")
    @Story("Alerts")
    @Description("checked the first text in alerts list ")
    public void alertHistoryTest() {
        assertEquals("6/6/2024",
                new MainPage()
                        .cookieWeg()
                        .goToalertsPage()
                        .getTextFromTable());
    }
    @Test
    @Epic("Web Interface")
    @Story("Alerts Settings")
    @Description("checked the toggle in Alerts Settings ")
    public void alertSettingsTest() {
        MainPage mainPage =  new MainPage();
        AlertSettingsPage alertSettingsPage = mainPage
                .cookieWeg()
                .goToalertsPage()
                .goToAlertsSettingsPage();
        alertSettingsPage.setToggleAndEmailCheckBox();
        WebElement togglerDeducted = alertSettingsPage.togglerDeducted;
        WebElement checkBox = alertSettingsPage.checkBox;

        assertTrue(togglerDeducted.isEnabled());
        assertTrue(checkBox.isEnabled());
    }
    @Test
    @Epic("Web Interface")
    @Story("Alerts Settings")
    @Description("change low balance ")
    public void alertSettingsChangeLowBalance(){

        AlertSettingsPage alertSettingsPage  = new MainPage()
                .cookieWeg()
                .goToalertsPage()
                .goToAlertsSettingsPage();
        alertSettingsPage.changeLowBalance();
        WebElement lowBalanceCheckBox = alertSettingsPage.lowBalanceCheckBox;
        WebElement lowBalanceInputField = alertSettingsPage.lowBalanceInputField;
        assertTrue(lowBalanceCheckBox.isEnabled());
        // TO DO make an assert to proof text in input field
      //  assertEquals("10000",lowBalanceInputField.getText());
    }


}
