package cucumberBank.pages;


import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static cucumberBank.context.TestContext.getWaitThreadLocal;


public class AlertSettingsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"check-deducted\"]")
    public WebElement togglerDeducted;

    @FindBy(css = "#mainContent > div.tab-content > div.tab-pane.active > div > div > div > div.alert-right > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > div:nth-child(1) > label > input[type=checkbox]")
    public WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"$8\"]")
    public WebElement lowBalanceInputField;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[3]/div[1]/div/div/div/div[2]/table/tbody/tr[9]/td[3]/div/div[1]/label/input")
    public WebElement lowBalanceCheckBox;




    public void setToggleAndEmailCheckBox() {
        togglerDeducted.click();
        checkBox.click();
    }

    public void changeLowBalance(String newBalance) {
        getWaitThreadLocal().until(ExpectedConditions.visibilityOf(lowBalanceInputField));
        lowBalanceInputField.click();
        lowBalanceInputField.clear();
        lowBalanceInputField.sendKeys(newBalance);
        lowBalanceInputField.click();
        lowBalanceCheckBox.click();
    }
}
