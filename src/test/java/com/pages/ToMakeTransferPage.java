package com.pages;


import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToMakeTransferPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"payFrom\"]")
    public WebElement payFromMenu;
    @FindBy(xpath = "//*[@class='close-btn1 close-btn2']")
    public WebElement popUpWindow;

    @FindBy(css = "#payFrom > div > ul > li:nth-child(1) > div")
    public WebElement plusBankingBankSelect;

    @FindBy(xpath = "//*[@id=\"payFrom\"]")
    public WebElement payToMenu;
    @FindBy(css = "#payTo > div > ul > li:nth-child(3) > div")
    public WebElement mortgageBankToTransfer;
    @FindBy(xpath = "//*[@id=\"payAmount\"]")
    public WebElement payAmount;

    @FindBy(xpath = "//*[@id=\"payHowOften\"]")
    public WebElement frequency;
    @FindBy(xpath = " //*[@id='payHowOften']/div/ul/li[1]/div/div'")
    public WebElement howOftenPay;
    @FindBy(className = "btn blue-btn-active mb-5 mt-4")
    public WebElement nextButton;
    @FindBy(className = "btn blue-btn-active m-left-1 mt-3")
    public WebElement transferButton;
    @FindBy(css = "#mainContent > div > div > div > div > div.tab-pane.active > div > div > div.make-p-lr.outac-margin.row > div:nth-child(1) > div")
    public WebElement successElement;


    public ToMakeTransferPage(TestContext context) {
        super(context);
    }

    public String getSuccessText() {
        context.wait.until(ExpectedConditions.visibilityOf(payFromMenu));
        payFromMenu.click();
        plusBankingBankSelect.click();
        payToMenu.click();
        mortgageBankToTransfer.click();
        payAmount.click();
        frequency.click();
        howOftenPay.click();
        nextButton.click();
        transferButton.click();
        context.wait.until(ExpectedConditions.visibilityOf(successElement));
        return successElement.getText();
    }
}

