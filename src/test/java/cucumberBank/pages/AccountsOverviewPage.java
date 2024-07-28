package cucumberBank.pages;


import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static cucumberBank.context.TestContext.wait;

public class AccountsOverviewPage extends BasePage {

    @FindBy(css = "#dealsTab")
    public WebElement offersAndDealsButton;
    @FindBy(xpath = "//*[@class='close-btn1 close-btn2']")
    public WebElement popUpWindow;
    @FindBy(xpath = "//*[@id='activity_process-bill-pay_special-offers']//..//p")
    public WebElement textFromOffersAndDeals;

    @FindBy(xpath = "//*[@class='billpay-dropdown dropdown nav-item']")
    public WebElement transferBetweenAccounts;

    @FindBy(xpath = "//*[@class='pt-0 d-flex m-0 card-title']")
    public List<WebElement> cardsTitle;
    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverviewButton;
    @FindBy(xpath = "//span[@class='top-link'][normalize-space()='Security Center']")
    public WebElement securityCenterLink;

    @FindBy(xpath = "//a[normalize-space()='Change Password']")
    public WebElement changePassLink;
    @FindBy(css = "#alertTab")
    public WebElement alertsTab;
    @FindBy(id="Popover1")
    public WebElement popOverInAlertTab;
    @FindBy(xpath = "//*[@id=\"alertTabPane\"]/div/div/div/div/div[1]/div[1]/div")
    public WebElement popOver;
    @FindBy(xpath = "//h2[text()='Your Balances Qualify You for Preferred Rewards']")
    public  WebElement textInPopOver;
   // @FindBy(css = "#close-confirmation-modal")
    @FindBy(xpath = "//*[@id=\"alertTabPane\"]/div/div/div/div/div[1]/div[1]/div/a")
    public WebElement closePopOverBtn;
    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div")
    public WebElement fullModalDialog;


   /* public AccountsOverviewPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App"));
    }*/

    public void clickOnOffersAndDealsBtn(){
        offersAndDealsButton.click();
    }
    public String getTextFromOffersAndDealsButton() {
        wait.until(ExpectedConditions.visibilityOf(textFromOffersAndDeals));
        return textFromOffersAndDeals.getText();
    }

    public int getNumbersOfCards() {
        return cardsTitle.size();
    }
    public SecurityDashboardPage goToChangePassword(){
        securityCenterLink.click();
        //changePassLink.click();
        return new SecurityDashboardPage();
    }
    public void upDate(){
        popUpWindow.click();
    }

    public void clickOnAlertsTab() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(alertsTab));
        alertsTab.click();
        popOverInAlertTab.click();
    }

    public String getAlertsText(){
        wait.until(ExpectedConditions.visibilityOf(textInPopOver));
        return textInPopOver.getText();
    }

}
