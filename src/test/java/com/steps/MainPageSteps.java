package com.steps;

import com.context.TestContext;
import com.pages.MainPage;
import com.utils.ConfigurationReader;
import com.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageSteps {
    private MainPage mainPage;
    Scenario scenario;
    TestContext context;

    @Before
    public void beforeEach(Scenario scenario){
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("url"));
        this.scenario =scenario;
    }

    @After
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) context.driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    @BeforeStep
    public void beforeStep()
    {
        scenario.log("Current URL:" + context.driver.getCurrentUrl());
    }


    @Given("I open a main page")
    public void i_open_a_main_page(){
        context.driver.get(ConfigurationReader.get("url"));
        scenario.log("entered main page");
    }


}
