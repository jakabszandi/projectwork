package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

import static browser.Settings.BASE_URL;


public class tescoSteps {

    WebDriver driver;

    private HomePage homePage;

    @BeforeAll
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public void closeBrowser() {
        driver.quit();
    }


    @Given("I open home page")
    public void iOpenHomePage() {
        driver.get(BASE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.isLoaded();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        homePage.acceptCookies();
    }

    @Given("the language is set to {string}")
    public void theLanguageIsSetTo(String input) {
        String currentLanguage;
        String savedLanguage = homePage.getLanguageText(driver);
        if (savedLanguage.equals("Magyar")){
            currentLanguage = "magyar";
        }else {
            currentLanguage = "english";
        }
    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String input) {

    }

    @Then("language is changed to {string}")
    public void languageIsChangedTo(String input) {

    }
}
