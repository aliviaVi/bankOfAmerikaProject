package cucumberBank.steps;

import cucumberBank.context.TestContext;
import cucumberBank.utils.ConfigurationReader;
import cucumberBank.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static cucumberBank.context.TestContext.closeThreadLocalDriver;
import static cucumberBank.context.TestContext.getThreadLocalDriver;


public class Hooks {

    @Before
    public void set(Scenario scenario) {
        WebDriver driver = DriverFactory.get();
        TestContext.setThreadLocalDriver(driver);
        driver.get(ConfigurationReader.get("base_url"));
        TestContext.scenario = scenario;
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = getThreadLocalDriver();
            if (driver != null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            }
        }
        closeDriver();
    }

    private  void closeDriver(){
        WebDriver driver = getThreadLocalDriver();
        if (driver!=null){
            driver.quit();
            closeThreadLocalDriver();
        }
    }
}
