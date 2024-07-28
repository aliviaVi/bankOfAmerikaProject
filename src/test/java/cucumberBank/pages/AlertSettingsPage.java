package cucumberBank.pages;


import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static cucumberBank.context.TestContext.wait;

public class AlertSettingsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"check-deducted\"]")
    public WebElement togglerDeducted;
   // @FindBy(xpath = "//div[contains(@class, 'alertEle collapse show')]")
   // public List<WebElement> listsOfEmailInputBox;
    @FindBy (css = "#mainContent > div.tab-content > div.tab-pane.active > div > div > div > div.alert-right > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(1) > label > input[type=checkbox]")
    public WebElement checkBox;
    @FindBy(xpath = "//h2[contains(text(), 'View Alerts for:')]")
    public WebElement viewAlertsText;
    @FindBy (xpath = "//*[@id=\"$8\"]")
    public WebElement lowBalanceInputField;
   @FindBy(xpath= "//*[@id=\"mainContent\"]/div[3]/div[1]/div/div/div/div[2]/table/tbody/tr[9]/td[3]/div/div[1]/label/input")
       public WebElement lowBalanceCheckBox;

   public String newBalance = "10000";
   public String newBalanceExtraLong = "34500000000000000000000000000000000";

   /* public AlertSettingsPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.visibilityOf(viewAlertsText));
    }*/

    public void setToggleAndEmailCheckBox(){
        togglerDeducted.click();
        checkBox.click();
    }

    public void changeLowBalance(String newBalance){
        wait.until(ExpectedConditions.visibilityOf(lowBalanceInputField));
        lowBalanceInputField.click();
        lowBalanceInputField.clear();
        lowBalanceInputField.sendKeys(newBalance);
        lowBalanceInputField.click();
        lowBalanceCheckBox.click();
    }


}
