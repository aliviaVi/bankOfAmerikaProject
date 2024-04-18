package tests;

import context.TestContext;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigurationReader;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {
    TestContext context;


    @BeforeEach
    public void beforeMethod(){
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.driver.get(ConfigurationReader.get("url"));
        context.logs =new StringBuilder();
    }

    @AfterEach
    public void afterMethod() {
        Allure.addAttachment("Console log:", String.valueOf(context.logs));
        if(context.driver!=null){
            context.driver.quit();
        }
    }
}
