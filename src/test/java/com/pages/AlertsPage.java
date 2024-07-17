package com.pages;


import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Alert history')]")
    public WebElement alertsHistoryTab;
   // @FindBy(xpath = "//a[contains(text(), 'Alert settings')]")
    @FindBy(xpath = "//*[@id=\"mainContent\"]/nav/ul/li[1]/a")
    public WebElement alertsSettingsTab;
    @FindBy(id = "toggle2")
    public WebElement elementInTable;
    @FindBy(css = "#toggle2 > td:nth-child(1)")
    public WebElement textInTable;
    @FindBy (linkText = "Alerts")
    public WebElement alertsButton;
    @FindBy(xpath = "//h2[contains(text(), 'View Alerts for:')]")
    public WebElement viewAlertsText;

    public AlertsPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/Alert/2"));
    }

    public String getTextFromTable()  {
        alertsHistoryTab.click();
        context.wait.until(ExpectedConditions.visibilityOf(elementInTable));
        return textInTable.getText();
    }
    public AlertsPage alertsClick(){
        alertsButton.click();
        return new AlertsPage(context);
    }
    public AlertSettingsPage goToAlertsSettingsPage(){
        alertsSettingsTab.click();
        context.wait.until(ExpectedConditions.visibilityOf(viewAlertsText));
        return  new AlertSettingsPage(context);
    }



}
