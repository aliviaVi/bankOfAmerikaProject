package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    @FindBy(css = "#mainContent > nav > ul > li:nth-child(2) > a")
    public WebElement alertsHistoryTab;
    @FindBy(id = "toggle2")
    public WebElement elementInTable;
    @FindBy(css = "#toggle2 > td:nth-child(1)")
    public WebElement textInTable;
    @FindBy (linkText = "Alerts")
    public WebElement alertsButton;

    public AlertsPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/Alert/2"));
    }

    public String getTextFromTable() {
        alertsHistoryTab.click();
        context.wait.until(ExpectedConditions.visibilityOf(elementInTable));
        return textInTable.getText();
    }
    public AlertsPage alertsClick(){
        alertsButton.click();
        return new AlertsPage(context);
    }

}
