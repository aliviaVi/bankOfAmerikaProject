package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AlertSettingsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"check-deducted\"]")
    public WebElement togglerDeducted;
   // @FindBy(xpath = "//div[contains(@class, 'alertEle collapse show')]")
   // public List<WebElement> listsOfEmailInputBox;
    @FindBy (css = "#mainContent > div.tab-content > div.tab-pane.active > div > div > div > div.alert-right > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(1) > label > input[type=checkbox]")
    public WebElement checkBox;
    @FindBy(xpath = "//h2[contains(text(), 'View Alerts for:')]")
    public WebElement viewAlertsText;

    public AlertSettingsPage(TestContext context) {
        super(context);
        context.wait.until(ExpectedConditions.visibilityOf(viewAlertsText));
    }

    public void setToggleAndEmailCheckBox(){
        togglerDeducted.click();
       // listsOfEmailInputBox.get(0).click();
        checkBox.click();
    }
}
