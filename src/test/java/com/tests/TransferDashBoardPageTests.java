package com.tests;

import com.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferDashBoardPageTests extends BaseTest{

    @Test
    @Epic("Web Interface")
    @Story("Transfer between customer accounts")
    @Description("made a transfer between firsts accounts")
    public void transferBetweenAccountsTest() {
        MainPage mainPage = new MainPage(context);
        assertEquals(mainPage
                        .cookieWeg()
                        .goToTransferDashboardPage()
                        .toMakeTransferPage()
                        .makeTransfer()
                        .clickTransfer()
                        .getTextSuccess(),
                "Your transfer is confirmed.");

    }
}
