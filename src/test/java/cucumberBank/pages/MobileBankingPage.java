package cucumberBank.pages;

import cucumberBank.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

import static cucumberBank.context.TestContext.driver;
import static cucumberBank.context.TestContext.wait;

public class MobileBankingPage extends BasePage {
    MobileAppSimulator mobileAppSimulator;

   /* public MobileBankingPage(TestContext context) {
        super(context);
        mobileAppSimulator = new MobileAppSimulator(context);
    }*/

    @FindBy(xpath = "//*[@class='mobile-banking-link']")
    public WebElement mobileBankingLink;

 /*   public MobileAppSimulator goToMobileAppSimulator() {
        wait.until(ExpectedConditions.visibilityOf(mobileBankingLink));
        mobileBankingLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!Objects.equals(windowHandle, mobileAppSimulator.defaultWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return mobileAppSimulator;
    }*/
}
