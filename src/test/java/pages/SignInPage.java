package pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "signin-button")
    WebElement signInBtn;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public HomePage fillOutFields(String input, String input2) {
        emailInput.sendKeys(input);
        passwordInput.sendKeys(input2);
        signInBtn.click();
        return new HomePage(driver);

    }
}
