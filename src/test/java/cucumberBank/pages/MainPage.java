package cucumberBank.pages;

import cucumberBank.context.TestContext;
import cucumberBank.utils.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static cucumberBank.context.TestContext.*;

public class MainPage extends BasePage {


    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement alertsButton;
    @FindBy(xpath = "//a[text()='Accounts Overview']")
    public WebElement accountOverviewButton;
    @FindBy(xpath = "//a[text()='Transfers']")
    public WebElement transfersButton;
    @FindBy(xpath = "//button[text()='Visit our Mobile Banking Simulator']")
    public WebElement mobileBankingButton;


    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    public WebElement cookieButton;

    @FindBy(xpath = "//*[@id='landing_after']")
    public WebElement goToAccountButton;
    @FindBy(css = "#alertTab")
    public WebElement alertsTab;
    @FindBy(id = "Popover1")
    public WebElement popOverInAlertTab;
    @FindBy(css = "button.ba-primary-btn")
    public WebElement updateOnlineBankingBtn;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/nav/ul/li[1]/a")
    public WebElement alertsSettingsTab;
    @FindBy(xpath = "//h2[contains(text(), 'View Alerts for:')]")
    public WebElement viewAlertsText;
    @FindBy(xpath = "//*[@id=\"device_iframe\"]")
    public WebElement deviceIframe;


    public MainPage cookieWeg() {
        getWaitThreadLocal().until(ExpectedConditions.visibilityOf(cookieButton));
        cookieButton.click();
        return new MainPage();
    }


    public AlertsPage goToalertsPage() {
        alertsButton.click();
        return new AlertsPage();
    }

    public AccountsOverviewPage goToAccountOverviewPage() {
        accountOverviewButton.click();
        getWaitThreadLocal().until(ExpectedConditions.visibilityOf(updateOnlineBankingBtn));
        updateOnlineBankingBtn.click();
        return new AccountsOverviewPage();

    }

    public TransferDashBoardPage goToTransferDashboardPage() {
        transfersButton.click();
        return new TransferDashBoardPage();
    }

    public MobileAppSimulator goToMobileBanking() throws InterruptedException {
        String mainWindow = getThreadLocalDriver().getWindowHandle();
        mobileBankingButton.click();
        Set<String> windowHandles = getThreadLocalDriver().getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(mainWindow)) {
                getThreadLocalDriver().switchTo().window(window);
            }
        }
        getWaitThreadLocal().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(deviceIframe));

        return new MobileAppSimulator();
    }

    public void closeWindowAfterAssert() {
        String mainWindow = DriverFactory.get().getWindowHandle();
        Set<String> windowHandles = DriverFactory.get().getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(mainWindow)) {
                DriverFactory.get().switchTo().window(mainWindow);
            }
        }
    }


    public AlertSettingsPage goToAlertsSettingsPage() {
        alertsSettingsTab.click();
        getWaitThreadLocal().until(ExpectedConditions.visibilityOf(viewAlertsText));
        return new AlertSettingsPage();
    }

}
