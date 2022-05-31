package tests;

import configurations.ConfigurationProvider;
import factories.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.StartPage;

public class PurchaseTest{
    private WebDriver webDriver;
    private ConfigurationProvider config;
    private StartPage startPage;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Before
    public void setUp(){
        webDriver = WebDriverFactory.getDriver();
        config = new ConfigurationProvider();

        startPage = PageFactory.initElements(webDriver, StartPage.class);
        homePage = PageFactory.initElements(webDriver, HomePage.class);
        productPage = PageFactory.initElements(webDriver, ProductPage.class);
        cartPage = PageFactory.initElements(webDriver, CartPage.class);
    }

    @Given("User connects to website")
    public void connectToSite(){
        webDriver.get(config.url());
    }

    @When("User logs in")
    public void logIn(){
        startPage.logIn(config.login(), config.password())
                .waitForLogin();
    }

    @When("choose category {string}")
    public void chooseCategory(String category){
        homePage.clickCategory(category);
    }

    @When("choose model {string}")
    public void chooseModel(String model){
        homePage.clickModel(model);
    }

    @When("add to cart")
    public void addToCart(){
        productPage.clickAddToCart()
                .closeAlert();
    }

    @When("open cart and click 'Place order'")
    public void openCartAndPlaceOrder(){
        productPage.clickCart();
        cartPage.clickPlaceOrder();
    }

    @When("fill in the order form:")
    public void fillOrderForm(DataTable data){
        cartPage.enterName(data.cell(0, 0))
                .enterCountry(data.cell(0, 1))
                .enterCity(data.cell(0, 2))
                .enterCard(data.cell(0, 3))
                .enterMonth(data.cell(0, 4))
                .enterYear(data.cell(0, 5))
                .clickPurchase();
    }

    @Then("pop-up {string} appears")
    public void then(String expectedText){
        Assert.assertTrue("Pop-up didn't appear.", cartPage.isPopupPresent());
        Assert.assertEquals("Pop-up message is not as expected.", expectedText, cartPage.getPopupMessage());
    }

    @After
    public void CleanupDriver(){
        webDriver.quit();
    }
}
