package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AuthenticatedPage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "btn-success")
    private WebElement addToCartButton;

    public ProductPage clickAddToCart(){
        clickOnElement(addToCartButton);
        return this;
    }
}
