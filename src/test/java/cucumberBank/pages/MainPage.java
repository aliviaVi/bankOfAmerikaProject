package cucumberBank.pages;

import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static cucumberBank.context.TestContext.wait;

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
    @FindBy(id="Popover1")
    public WebElement popOverInAlertTab;
    @FindBy(xpath = "//*[@id=\"alertTabPane\"]/div/div/div/div/div[1]/div[1]/div")
    public WebElement popOver;
    @FindBy(xpath = "//h2[text()='Your Balances Qualify You for Preferred Rewards']")
    public  WebElement textInPopOver;
    @FindBy(css = "close-confirmation-modal")
    public WebElement closePopOverBtn;
    @FindBy(xpath = "//button[text()='Update now']")
    public WebElement updateOnlineBankingBtn;

    public MainPage cookieWeg() {
        wait.until(ExpectedConditions.visibilityOf(cookieButton));
        cookieButton.click();
        return new MainPage();
    }

    public String TextGoToButton () {

        return goToAccountButton.getText();
    }


    public AlertsPage goToalertsPage() {
        alertsButton.click();
        return new AlertsPage();
    }

    public AccountsOverviewPage goToAccountOverviewPage() {
        accountOverviewButton.click();
        wait.until(ExpectedConditions.visibilityOf(updateOnlineBankingBtn));
        wait.until(ExpectedConditions.visibilityOf(closePopOverBtn));
        updateOnlineBankingBtn.click();
        return new AccountsOverviewPage();

    }

    public TransferDashBoardPage goToTransferDashboardPage() {
        transfersButton.click();
        return new TransferDashBoardPage();
    }

    public MobileBankingPage goToMobileBanking() {
        mobileBankingButton.click();
        return new MobileBankingPage();
    }
    public void goToCheckAlertsText(){
        alertsTab.click();
        popOverInAlertTab.click();
    }


}
