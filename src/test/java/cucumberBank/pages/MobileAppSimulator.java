package cucumberBank.pages;

import cucumberBank.context.TestContext;
import cucumberBank.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static cucumberBank.context.TestContext.*;


public class MobileAppSimulator extends BasePage {
  //  String defaultWindow = context.driver.getWindowHandle();

   /* public MobileAppSimulator(TestContext context) {
        super(context);
    }*/

   // @FindBy(id = "device_iframe")
   // @FindBy(xpath = "//*[@id=\"device_iframe\"]")
   // @FindBy(css = "#device_iframe")
    @FindBy(tagName = "iframe")
    public WebElement deviceIframe;
   // @FindBy(id = "username_field")
    @FindBy(css = "#username_field")
    public WebElement userNameField;
    @FindBy(id = "passcode_field")
    public WebElement passwordField;
    @FindBy(id = "sign_in_button")
    public WebElement logInButton;
    @FindBy(xpath = "//*[@class=\"alerts_left_side\"]")
    public WebElement elementWithTextAfterLogin;
    @FindBy(xpath = "//*[@class='bac_button blue'] [text()='Online Banking Simulator']")
    public WebElement onlineBankingSimulatorButton;
    @FindBy(xpath = "//button[text()='Accept All Optional Cookies']")
    public WebElement acceptMobileCookiesBtn;


    public void mobileAppLogIn() {
      // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(deviceIframe));
     //  getDriver().switchTo().frame(deviceIframe);
      //  driver.switchTo().frame(deviceIframe);
        wait.until(ExpectedConditions.visibilityOf(acceptMobileCookiesBtn));
        acceptMobileCookiesBtn.click();
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.click();
        userNameField.sendKeys(ConfigurationReader.get("userName"));
        passwordField.click();
        passwordField.sendKeys(ConfigurationReader.get("userPassword"));
        logInButton.click();
    }

    public String getHelloTextFromBankingApp() {
        wait.until(ExpectedConditions.visibilityOf(elementWithTextAfterLogin));
        return elementWithTextAfterLogin.getText();
    }

    public boolean isBankingSimulatorButtonPresent() {
        driver.switchTo().defaultContent();
        return onlineBankingSimulatorButton.isDisplayed();
    }
}
