package com.tests;

import com.pages.AccountsOverviewPage;
import com.pages.BasePage;
import com.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests extends BaseTest {


    @Test
    @Epic("Web Interface")
    @Story("Offers and deals")
    @Description("checked special offers for customer")
    public void offersAndDealsTextTest() {
        MainPage mainPage = new MainPage(context);
        assertEquals(mainPage
                        .cookieWeg()
                        .goToAccountOverviewPage()
                        .getTextFromOffersAndDealsButton(),
                "Because you're a valued customer, we've selected some special offers just for you.");
    }




}
