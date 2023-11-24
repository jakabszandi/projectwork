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
import pages.SignInPage;

import java.time.Duration;

import static browser.Settings.BASE_URL;


public class tescoSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeAll
    public static void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void closeBrowser() {
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
        if (savedLanguage.equals("Magyar")) {
            currentLanguage = "magyar";
        } else {
            currentLanguage = "english";
        }
    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String input) {
        homePage.changeLanguage();
    }

    @Then("language is changed to {string}")
    public void languageIsChangedTo(String input) {
        /*String currentLanguage;
        String savedLanguage = homePage.getLanguageText(driver);
        if (savedLanguage.equals("Magyar")){
            currentLanguage = "magyar";
        }else {
            currentLanguage = "english";
        }*/
    }

    @And("I open Sign in page")
    public void iOpenSignInPage() {
        SignInPage signInPage = homePage.signIn();
    }

    @When("I login with following credentials:")
    public void iLoginWithFollowingCredentials(String input, String input2) {
        HomePage homePage = signInPage.fillOutFields(input, input2);
    }

    @Then("headline contains the word {string}")
    public void headlineContainsTheWord(String input) {
        homePage.checkHeadlineText(input);
    }

    @And("logout button is present")
    public void logoutButtonIsPresent() {
        homePage.checkLogoutBtn();
    }

    @When("I click logout button")
    public void iClickLogoutButton() {
        homePage.logout();
    }

    @Then("login button is present")
    public void loginButtonIsPresent() {
        homePage.checkSignInBtn();
    }
}
