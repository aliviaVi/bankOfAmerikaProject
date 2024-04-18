package pages;

import
        context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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


    public AccountsOverviewPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.urlToBe("https://message.bankofamerica.com/onlinebanking_demo/OLB_Simulator/App"));
    }

    public String getTextFromOffersAndDealsButton() {
        popUpWindow.click();
        offersAndDealsButton.click();

        context.wait.until(ExpectedConditions.visibilityOf(textFromOffersAndDeals));
        return textFromOffersAndDeals.getText();
    }

    public int getNumbersOfCards() {
        return cardsTitle.size();
    }
    public SecurityDashboardPage goToChangePassword(){
        securityCenterLink.click();
        //changePassLink.click();
        return new SecurityDashboardPage(context);
    }
    public void upDate(){
        popUpWindow.click();
    }
}
