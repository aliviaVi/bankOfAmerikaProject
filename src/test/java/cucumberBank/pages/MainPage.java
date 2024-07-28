package cucumberBank.pages;

import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(xpath = "//*[@id=\"alertTabPane\"]/div/div/div/div/div[1]/div[1]/div")
    public WebElement popOver;
    @FindBy(xpath = "//h2[text()='Your Balances Qualify You for Preferred Rewards']")
    public WebElement textInPopOver;
    @FindBy(css = "#close-confirmation-modal")
    public WebElement closePopOverBtn;
   // @FindBy(xpath = "//button[text()='Update now']")
    @FindBy(css = "button.ba-primary-btn")
    public WebElement updateOnlineBankingBtn;
    @FindBy(css = "#ba-secondary-btn")
    public WebElement remindMeLater;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/nav/ul/li[1]/a")
    public WebElement alertsSettingsTab;
    @FindBy(xpath = "//h2[contains(text(), 'View Alerts for:')]")
    public WebElement viewAlertsText;
    @FindBy(xpath = "//*[@id=\"device_iframe\"]")
    public WebElement deviceIframe;
   // @FindBy(xpath = "//button[text()='Accept All Optional Cookies']")
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement acceptMobileCookiesBtn;


    public MainPage cookieWeg() {
        wait.until(ExpectedConditions.visibilityOf(cookieButton));
        cookieButton.click();
        return new MainPage();
    }

    public String TextGoToButton() {

        return goToAccountButton.getText();
    }


    public AlertsPage goToalertsPage() {
        alertsButton.click();
        return new AlertsPage();
    }

    public AccountsOverviewPage goToAccountOverviewPage() {
        accountOverviewButton.click();
        wait.until(ExpectedConditions.visibilityOf(updateOnlineBankingBtn));
        updateOnlineBankingBtn.click();
        return new AccountsOverviewPage();

    }

    public TransferDashBoardPage goToTransferDashboardPage() {
        transfersButton.click();
        return new TransferDashBoardPage();
    }

    public MobileAppSimulator goToMobileBanking() throws InterruptedException {
        mobileBankingButton.click();
        Thread.sleep(5000);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(deviceIframe));
      //  getDriver().switchTo().frame(deviceIframe);
        return new MobileAppSimulator();
    }

    public void goToCheckAlertsText() {
        alertsTab.click();
        popOverInAlertTab.click();
    }
    public AlertSettingsPage goToAlertsSettingsPage(){
        alertsSettingsTab.click();
        wait.until(ExpectedConditions.visibilityOf(viewAlertsText));
        return  new AlertSettingsPage();
    }


}
