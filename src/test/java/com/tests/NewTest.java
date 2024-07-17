package com.tests;


import com.pages.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NewTest extends BaseTest {

    @Test

    public void firstTest() {
        assertEquals(new MainPage(context)
                        .cookieWeg()
                        .TextGoToButton(),
                "Go to Accounts Overview");
    }
}



