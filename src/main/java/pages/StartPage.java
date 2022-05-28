package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends WebBasePage{

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login2")
    private WebElement loginHeader;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement logInButton;

    public StartPage logIn(String login, String password){
        loginHeader.click();
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        logInButton.click();
        return this;
    }

    public void waitForLogin(){
        wait.until(driver -> ExpectedConditions.invisibilityOf(logInButton));
    }
}
