package cucumberBank.pages;


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
    @FindBy(xpath = "//*[@class='pt-0 d-flex m-0 card-title']")
    public List<WebElement> cardsTitle;
    @FindBy(xpath = "//span[@class='top-link'][normalize-space()='Security Center']")
    public WebElement securityCenterLink;
    @FindBy(css = "#alertTab")
    public WebElement alertsTab;
    @FindBy(id = "Popover1")
    public WebElement popOverInAlertTab;
    @FindBy(xpath = "//h2[text()='Your Balances Qualify You for Preferred Rewards']")
    public WebElement textInPopOver;


    public void clickOnOffersAndDealsBtn() {
        offersAndDealsButton.click();
    }

    public String getTextFromOffersAndDealsButton() {
        wait.until(ExpectedConditions.visibilityOf(textFromOffersAndDeals));
        return textFromOffersAndDeals.getText();
    }

    public int getNumbersOfCards() {
        return cardsTitle.size();
    }

    public SecurityDashboardPage goToChangePassword() {
        securityCenterLink.click();
        return new SecurityDashboardPage();
    }

    public void clickOnAlertsTab() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(alertsTab));
        alertsTab.click();
        popOverInAlertTab.click();
    }

    public String getAlertsText() {
        wait.until(ExpectedConditions.visibilityOf(textInPopOver));
        return textInPopOver.getText();
    }

}
