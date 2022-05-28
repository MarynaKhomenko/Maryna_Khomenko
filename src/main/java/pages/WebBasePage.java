package pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebBasePage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public WebBasePage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    protected void clickOnElement(WebElement element){
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void clickOnElementRetry(WebElement element){
        for(int i=0; i<3; i++){
            try{
                clickOnElement(element);
                break;
            }
            catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
        }
    }

    public void closeAlert(){
        wait.until(driver -> ExpectedConditions.alertIsPresent());
        for(int i=0; i<3; i++){
            try{
                webDriver.switchTo().alert().accept();
                wait.until(webDriver -> ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
                break;
            }
            catch(NoAlertPresentException e){
                e.printStackTrace();
            }
        }
    }
}
