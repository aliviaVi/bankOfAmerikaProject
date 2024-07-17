package com.pages;

import com.context.TestContext;
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
        updateOnlineBankingBtn.click();

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
    public void goToCheckAlertsText(){
        alertsTab.click();
        popOverInAlertTab.click();
    }


}
