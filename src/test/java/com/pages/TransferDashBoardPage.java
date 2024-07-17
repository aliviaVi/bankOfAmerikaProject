package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TransferDashBoardPage extends BasePage {
    public TransferDashBoardPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//div[text()='Between my accounts at Bank of America']/..")
    public WebElement betweenMyAccountsButton;
    @FindBy(id = "payFrom")
    public WebElement fieldTransferMoneyFrom;
    @FindBy(xpath = "//div[@id='payFrom']/div/ul/li")
    public List<WebElement> listTransferMoneyFrom;

    @FindBy(id = "payTo")
    public WebElement fieldTransferMoneyTo;
    @FindBy(xpath = "//div[@id='payTo']/div/ul/li")
    public List<WebElement> listTransferMoneyTo;

    @FindBy(id = "payAmount")
    public WebElement fieldAmount;

    @FindBy(id = "payHowOften")
    public WebElement fieldFrequency;
    @FindBy(xpath = "//div[@id='payHowOften']/div/ul/li")
    public List<WebElement> listFrequency;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement buttonNext;

    @FindBy(xpath = "//a[text()='Transfer']")
    public WebElement buttonTransfer;
    @FindBy(xpath = "//*[@id='mainContent']//span")
    public WebElement result;



    public TransferDashBoardPage toMakeTransferPage() {
        betweenMyAccountsButton.click();
        return new TransferDashBoardPage(context);
    }

    public TransferDashBoardPage makeTransfer() {
        context.wait.until(ExpectedConditions.visibilityOf(fieldTransferMoneyFrom));
        fieldTransferMoneyFrom.click();
        listTransferMoneyFrom.getFirst().click();
        fieldTransferMoneyTo.click();
        listTransferMoneyTo.get(1).click();
        fieldAmount.click();
        fieldFrequency.click();
        listFrequency.getFirst().click();
        buttonNext.click();
        return new TransferDashBoardPage(context);
    }

    public TransferDashBoardPage clickTransfer() {
        buttonTransfer.click();
        return new TransferDashBoardPage(context);
    }

    public String getTextSuccess() {
        return result.getText();
    }


}
