package pages;

import baseItems.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //@FindBy(xpath = "//*[@id='content']/div/div/div[2]/div/header/div/div[1]/div[2]/a/svg")
    //WebElement tescoLogo;

    @FindBy(xpath = "//*[@id='sticky-bar-cookie-wrapper']/span/div/div/div[2]/form[1]/button/span")
    WebElement acceptCookieBtn;

    @FindBy(id = "utility-header-language-switch-link")
    WebElement switchLanguageBtn;

    @FindBy(xpath = "//*[@id='utility-header-login-link']/span")
    WebElement signInButton;

    @FindBy(id = "utility-header-logout-link")
    WebElement logOutBtn;

    @FindBy(id = "utility-header-greetings")
    WebElement headline;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        acceptCookieBtn.click();
    }

    public boolean isLoaded() {
        return isLoaded(acceptCookieBtn)
                && isLoaded(signInButton) && isLoaded(switchLanguageBtn);
    }

    public String getLanguageText(WebDriver driver) {
        return switchLanguageBtn.getText();
    }

    public void changeLanguage() {
        switchLanguageBtn.click();
    }

    public SignInPage signIn() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public void checkHeadlineText(String input) {
        String headlineText = headline.getText();
        Assertions.assertEquals(input, headlineText);
    }

    public void checkLogoutBtn() {
        Assertions.assertTrue(logOutBtn.isDisplayed());
    }

    public void logout() {
        logOutBtn.click();
    }

    public void checkSignInBtn() {
        Assertions.assertTrue(signInButton.isDisplayed());
    }
}
