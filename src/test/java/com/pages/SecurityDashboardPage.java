package com.pages;

import com.context.TestContext;
import com.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import utils.ConfigurationReader;

public class SecurityDashboardPage extends BasePage{

    String NEW_PASSWORD = "112233";

    public SecurityDashboardPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath ="//button[normalize-space()='Update password']")
    public WebElement slideBarUpdatePasswordButton;
    @FindBy(xpath = "//div[@class='carousel-item active']//button")
    public WebElement slideBarChangePasscode;
    @FindBy(xpath = "//div[@class='init-modal-header modal-header']")
    public WebElement modalHeader;

    @FindBy(xpath = "//input[@name='label1']")
    public WebElement inputCurrentPasswordField;
    @FindBy(xpath = "//input[@name='label2']")
    public WebElement inputNewPasswordField;
    @FindBy(xpath = "//input[@name='label3']")
    public WebElement inputRetypeNewPasswordField;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='passcode-success']")
    public WebElement passcodeSuccess;
    @FindBy(xpath = "//button[normalize-space()='Done']")
    public WebElement doneButton;


    public void changePassword(){
        slideBarUpdatePasswordButton.click();
        context.wait.until(ExpectedConditions.visibilityOf(modalHeader));
        inputCurrentPasswordField.click();
        inputCurrentPasswordField.clear();
        inputCurrentPasswordField.sendKeys(ConfigurationReader.get("userPassword"));
        inputNewPasswordField.click();
        inputNewPasswordField.clear();
        inputNewPasswordField.sendKeys(NEW_PASSWORD);
        inputRetypeNewPasswordField.sendKeys(NEW_PASSWORD);

        saveButton.click();
    }

    public String getText(){
      return  passcodeSuccess.getText();
    }

    public void submitNewPassword(){
        doneButton.click();
    }


}
