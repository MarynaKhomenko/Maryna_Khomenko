package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AuthenticatedPage extends WebBasePage{
    public AuthenticatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cartur")
    protected WebElement cartHeader;

    public void clickCart(){
        cartHeader.click();
    }
}
