package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OlbSimulatorPage extends BasePage {
    @FindBy (linkText = "Alerts")
    public WebElement alertsButton;
    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverviewButton;

    public OlbSimulatorPage(TestContext context) {
        super(context);
    }


    public AlertsPage alertsClick(){
        alertsButton.click();
        return new AlertsPage(context);
    }

    public AccountsOverviewPage overviewPageClick(){
        accountsOverviewButton.click();
        return new AccountsOverviewPage(context);
    }
}
