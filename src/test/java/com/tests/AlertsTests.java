package com.tests;

import com.pages.AlertSettingsPage;
import com.pages.AlertsPage;
import com.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTests  extends BaseTest {
    @Test
    @Epic("Web Interface")
    @Story("Alerts")
    @Description("checked the first text in alerts list ")
    public void alertHistoryTest() {
        assertEquals(new MainPage(context)
                        .cookieWeg()
                        .goToalertsPage()
                        .getTextFromTable(),
                "6/6/2024");
    }
    @Test
    @Epic("Web Interface")
    @Story("Alerts Settings")
    @Description("checked the toggle in Alerts Settings ")
    public void alertSettingsTest() {
        MainPage mainPage =  new MainPage(context);
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
    @Epic("Web Interface")
    @Story("Alerts Settings")
    @Description("change low balance ")
    public void alertSettingsChangeLowBalance(){
        MainPage mainPage = new MainPage(context);
        mainPage.cookieWeg();
        AlertsPage alertsPage = mainPage.goToalertsPage();
        AlertSettingsPage alertSettingsPage = alertsPage.goToAlertsSettingsPage();
        alertSettingsPage.changeLowBalance();
        WebElement lowBalanceCheckBox = alertSettingsPage.lowBalanceCheckBox;
        WebElement lowBalanceInputField = alertSettingsPage.lowBalanceInputField;


        assertTrue(lowBalanceCheckBox.isEnabled());
      //  assertEquals("10000",lowBalanceInputField.getText());
    }


}
