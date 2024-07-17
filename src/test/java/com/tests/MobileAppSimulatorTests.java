package com.tests;

import com.pages.MainPage;
import com.pages.MobileAppSimulator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileAppSimulatorTests extends BaseTest {
    @Test
    @Epic("Mobile web interface")
    @Story("mobile Banking")
    @Description("checked a login possibility throw mobile interface")
    public void mobileBankingAppTest() {
        MobileAppSimulator mobileAppSimulator = new MainPage(context)
                .cookieWeg()
                .goToMobileBanking()
                .goToMobileAppSimulator();
        mobileAppSimulator.mobileAppLogIn();

        assertEquals("Hello, Robin\nPreferred Rewards Platinum Member", mobileAppSimulator.getHelloTextFromBankingApp()) ;
        assertTrue(mobileAppSimulator.isBankingSimulatorButtonPresent());

    }
}
