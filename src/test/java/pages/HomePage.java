package pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//svg[@class='ddsweb-tesco-logo__svg']")
    WebElement tescoLogo;

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span")
    WebElement acceptCookieBtn;

    @FindBy(id = "utility-header-language-switch-link")
    WebElement switchLanguageBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        acceptCookieBtn.click();
    }

    public boolean isLoaded() {
        return isLoaded(acceptCookieBtn)
                && isLoaded(tescoLogo) && isLoaded(switchLanguageBtn);
    }

    public String getLanguageText(WebDriver driver) {
        String languageText = switchLanguageBtn.getText();
        return languageText;
    }

    public void changeLanguage(){

    }
}
