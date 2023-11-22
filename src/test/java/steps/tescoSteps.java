package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static browser.Settings.BASE_URL;

public class tescoSteps {

    WebDriver driver;

    @BeforeAll
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("I open home page")
    public void iOpenHomePage() {
        driver.get(BASE_URL);
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
    }

    @Given("the language is set to {string}")
    public void theLanguageIsSetTo(String arg0) {
    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String arg0) {
    }

    @Then("language is changed to {string}")
    public void languageIsChangedTo(String arg0) {
    }
}
