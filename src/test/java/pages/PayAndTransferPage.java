package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayAndTransferPage  extends BasePage {

    @FindBy(css = "#mainContent > div > div > div.mb-4.activity-wrapper.row > div:nth-child(1) > div > a > div")
    public WebElement transferBetweenAccountsButton;
    public PayAndTransferPage(TestContext context) {
        super(context);
    }


    public ToMakeTransferPage goToMakeTransfer(){
        context.wait.until(ExpectedConditions.visibilityOf(transferBetweenAccountsButton));
        transferBetweenAccountsButton.click();
        return new ToMakeTransferPage(context);
    }
}
