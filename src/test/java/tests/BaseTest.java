package tests;

import context.TestContext;
import io.qameta.allure.Allure;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    TestContext context;


    @BeforeMethod
    public void beforeMethod() {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("url"));
        context.logs = new StringBuilder();
    }

    @AfterMethod
    public void afterMethod() {
        Allure.addAttachment("Console log: ", String.valueOf(context.logs));
        Allure.getLifecycle().addAttachment(
                "Screenshot", "image/png", "png",
                ((TakesScreenshot) context.driver).getScreenshotAs(OutputType.BYTES)
        );
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}

