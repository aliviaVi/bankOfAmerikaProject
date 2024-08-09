package cucumberBank.context;

import cucumberBank.utils.ConfigurationReader;
import cucumberBank.utils.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {


    private static final ThreadLocal<WebDriver>  threadLocalDriver = new ThreadLocal<>();
    private static final ThreadLocal <WebDriverWait> threadLocalWait = new ThreadLocal<>();
  //  private static final ThreadLocal<Actions> threadLocalActions = new ThreadLocal<>();
    private static final ThreadLocal <JavascriptExecutor> threadLocalJs = new ThreadLocal<>();

    public static Scenario scenario;


    public static  WebDriver getThreadLocalDriver(){
        return threadLocalDriver.get();
    }
    public static WebDriverWait getWaitThreadLocal(){
        return threadLocalWait.get();
    }

    public static void setThreadLocalDriver(WebDriver driver){
        threadLocalDriver.set(driver);
        threadLocalWait.set(new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout")))));
        threadLocalJs.set((JavascriptExecutor)(driver));
    }

    public static void closeThreadLocalDriver(){
        threadLocalDriver.remove();
    }


}
