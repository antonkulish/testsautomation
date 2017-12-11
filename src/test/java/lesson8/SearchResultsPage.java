package lesson8;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name' and contains(.,'Blouse')]")
    WebElement productName;

    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name' and contains(.,'Blouse')]/../..//a[@title='Add to cart']")
    WebElement addToCartButton;

    //@FindBy(xpath = "//div[@id='layer_cart']//a[@title='Proceed to checkout']/span[contains(.,'Proceed to checkout')]")
    //WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cartButton;

    SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickAddToCartBtn(){
        LOG.info("Add product to Cart");
        new Actions(webDriver).moveToElement(webDriver.findElement(By.xpath("//div[@class='product-image-container']"))).perform();
        addToCartButton.click();
    }
/*
    public ShoppingCartPage proceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
        for (String currentWindow: webDriver.getWindowHandles())
            webDriver.switchTo().window(currentWindow);
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn));
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        proceedToCheckoutBtn.click();
        return new ShoppingCartPage(webDriver);
    }
*/

    public ShoppingCartPage navigateToCart(){
        LOG.info("Open Shopping Cart");
        webDriver.findElement(By.id("header_logo")).click();
        cartButton.click();
        return new ShoppingCartPage(webDriver);
    }
}
