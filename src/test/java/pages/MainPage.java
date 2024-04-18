package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement alertsButton;
    @FindBy(xpath = "//a[text()='Accounts Overview']")
    public WebElement accountOverviewButton;
    @FindBy(xpath = "//a[text()='Transfers']")
    public WebElement transfersButton;
    @FindBy(xpath = "//a[text()='Mobile Banking']")
    public WebElement mobileBankingButton;




    public AlertsPage goToalertsPage() {
        alertsButton.click();
        return new AlertsPage(context);
    }

    public AccountsOverviewPage goToAccountOverviewPage() {
        accountOverviewButton.click();
        return new AccountsOverviewPage(context);

    }

    public TransferDashBoardPage goToTransferDashboardPage() {
        transfersButton.click();
        return new TransferDashBoardPage(context);
    }

    public MobileBankingPage goToMobileBanking() {
        mobileBankingButton.click();
        return new MobileBankingPage(context);
    }


}
