package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver get() {
        String browser = ConfigurationReader.get("browser");
        String url = ConfigurationReader.get("url");
        WebDriver driver;

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--lang=en-en");
                    options.addArguments("--enable-experimental-cookie-features");
                }
                driver = new ChromeDriver(options);
               /* Cookie cookie = new Cookie.Builder("TS01aa6438", "01dc75eb527bc1abcaa1ec47fca395efb767d037cc299dabf56e3f9adfe19cd980f8508c9e60932f6682dc81fc7567ac98cb305972")
                        .domain(".bankofamerica.com")
                        .path("/")
                        .isSecure(true)
                        .build();

                driver.manage().addCookie(cookie);

                try {
                    Thread.sleep(5000);  // Замените значение на необходимое для полной загрузки страницы
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.navigate().refresh();*/
               // driver.manage().deleteAllCookies();


                if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                    driver.manage().window().maximize();
                }
                return driver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                    throw new WebDriverException("Your OS not support lounge of this browser");
                }
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
        }
        throw new WebDriverException("WebDriver not selected in configuration file");
    }
}
