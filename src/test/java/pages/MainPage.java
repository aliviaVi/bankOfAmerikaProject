package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement cookieButton;

    @FindBy(xpath = "//*[@id='landing_after']")
    public WebElement goToAccountButton;

    public MainPage cookieWeg() {
        context.wait.until(ExpectedConditions.visibilityOf(cookieButton));
        cookieButton.click();
        return new MainPage(context);
    }

    public String TextGoToButton () {

        return goToAccountButton.getText();
    }
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
