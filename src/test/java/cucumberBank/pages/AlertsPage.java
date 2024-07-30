package cucumberBank.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static cucumberBank.context.TestContext.wait;

public class AlertsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Alert history')]")
    public WebElement alertsHistoryTab;
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


    public String getTextFromTable()  {
        alertsHistoryTab.click();
        wait.until(ExpectedConditions.visibilityOf(elementInTable));
        return textInTable.getText();
    }

    public AlertSettingsPage goToAlertsSettingsPage(){
        alertsSettingsTab.click();
        wait.until(ExpectedConditions.visibilityOf(viewAlertsText));
        return  new AlertSettingsPage();
    }

}
