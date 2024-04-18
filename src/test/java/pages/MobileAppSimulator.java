package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationReader;

public class MobileAppSimulator extends BasePage {
    String defaultWindow = context.driver.getWindowHandle();

    public MobileAppSimulator(TestContext context) {
        super(context);
    }

    @FindBy(id = "device_iframe")
    public WebElement deviceIframe;
    @FindBy(id = "username_field")
    public WebElement userNameField;
    @FindBy(id = "passcode_field")
    public WebElement passwordField;
    @FindBy(id = "sign_in_button")
    public WebElement logInButton;
    @FindBy(xpath = "//*[@class=\"alerts_left_side\"]")
    public WebElement elementWithTextAfterLogin;
    @FindBy(xpath = "//*[@class='bac_button blue'] [text()='Online Banking Simulator']")
    public WebElement onlineBankingSimulatorButton;


    public void mobileAppLogIn() {
        context.wait.until(ExpectedConditions.visibilityOf(deviceIframe));
        userNameField.click();
        userNameField.sendKeys(ConfigurationReader.get("userName"));
        passwordField.click();
        passwordField.sendKeys(ConfigurationReader.get("userPassword"));
        logInButton.click();
    }

    public String getHelloTextFromBankingApp() {
        return elementWithTextAfterLogin.getText();
    }

    public boolean isBankingSimulatorButtonPresent() {
        return onlineBankingSimulatorButton.isDisplayed();
    }
}
