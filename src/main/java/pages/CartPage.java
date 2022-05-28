package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends WebBasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "btn-success")
    private WebElement placeOrderButton;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "card")
    private WebElement cardField;
    @FindBy(id = "month")
    private WebElement monthField;
    @FindBy(id = "year")
    private WebElement yearField;
    @FindBy(css = "[onclick='purchaseOrder()']")
    private WebElement purchaseButton;
    @FindBy(css = "div.sweet-alert h2")
    private WebElement popupText;
    @FindBy(className = "confirm")
    private WebElement okButton;

    public void clickPlaceOrder(){
        for(int i=0; i<3; i++){
            try{
                clickOnElement(placeOrderButton);
                break;
            }
            catch (UnhandledAlertException e){
                e.printStackTrace();
            }
        }
    }

    public CartPage waitFormAppear(){
        wait.until(driver -> ExpectedConditions.visibilityOf(nameField));
        return this;
    }

    public CartPage enterName(String name){
        nameField.sendKeys(name);
        return this;
    }

    public CartPage enterCountry(String country){
        countryField.sendKeys(country);
        return this;
    }

    public CartPage enterCity(String city){
        cityField.sendKeys(city);
        return this;
    }

    public CartPage enterCard(String card){
        cardField.sendKeys(card);
        return this;
    }

    public CartPage enterMonth(String month){
         monthField.sendKeys(month);
        return this;
    }

    public CartPage enterYear(String year){
        yearField.sendKeys(year);
        return this;
    }

    public void clickPurchase(){
        purchaseButton.click();
    }

    public boolean isPopupPresent(){
        try{
            wait.until(driver -> popupText.isDisplayed());
            return true;
        }
        catch(TimeoutException e){
            return false;
        }
    }

    public String getPopupMessage(){
        return popupText.getText();
    }
}
