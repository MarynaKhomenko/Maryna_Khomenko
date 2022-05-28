package pages;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AuthenticatedPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@id='itemc' and text()='Laptops']")
    private WebElement laptopsButton;

    public void clickLaptopsButton(){
        clickOnElementRetry(laptopsButton);
    }

    public void clickCategory(String category){
        switch(category){
            case "Laptops":
                clickLaptopsButton();
                break;
            default:
                throw new NotImplementedException();
        }
    }

    public void clickModel(String model){
        By locator = By.xpath(String.format("//a[text()='%s']", model));
        wait.until(driver -> ExpectedConditions.presenceOfElementLocated(locator));
        webDriver.findElement(locator).click();
    }
}
