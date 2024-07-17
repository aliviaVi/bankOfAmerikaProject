package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class MobileBankingPage extends BasePage {
    MobileAppSimulator mobileAppSimulator;

    public MobileBankingPage(TestContext context) {
        super(context);
        mobileAppSimulator = new MobileAppSimulator(context);
    }

    @FindBy(xpath = "//*[@class='mobile-banking-link']")
    public WebElement mobileBankingLink;

    public MobileAppSimulator goToMobileAppSimulator() {
        context.wait.until(ExpectedConditions.visibilityOf(mobileBankingLink));
        mobileBankingLink.click();
        context.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : context.driver.getWindowHandles()) {
            if (!Objects.equals(windowHandle, mobileAppSimulator.defaultWindow)) {
                context.driver.switchTo().window(windowHandle);
            }
        }
        return mobileAppSimulator;
    }
}
