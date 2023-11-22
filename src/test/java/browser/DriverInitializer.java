package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverInitializer {

    public static WebDriver initDriver(BrowserType browserType) {
        switch(browserType) {
            case CHROME_SELENIUM_MGR:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--incognito");
                return new ChromeDriver();
            case CHROME_PORTABLE:
                System.setProperty("webdriver.chrome.driver", Settings.CHROMEDRIVER_PORTABLE_PATH);
                ChromeOptions options = new ChromeOptions();
                options.setBinary(Settings.CHROME_PORTABLE_PATH);
                options.addArguments("incognito");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Incorrect browser type!");
        }
    }
}
