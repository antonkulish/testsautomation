package lesson8;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//p/a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutBtn;

    @FindBy(name = "processAddress")
    WebElement processAddressBtn;

    @FindBy(name = "cgv")
    WebElement agreeTheTermsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    WebElement processCarrierBtn;

    @FindBy(className = "bankwire")
    WebElement bankwireBtn;

    @FindBy(xpath = "//button[@type='submit']/span[contains(.,'I confirm my order')]")
    WebElement confirmOrderBtn;

    @FindBy(className = "box")
    WebElement orderConfirmationBox;

    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrdersBtn;

    ShoppingCartPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void confirmBuyingThroughTheCart(){
        LOG.info("Proceed to checkout and confirm order");
        proceedToCheckoutBtn.click();
        processAddressBtn.click();
        agreeTheTermsOfServiceCheckbox.click();
        processCarrierBtn.click();
        bankwireBtn.click();
        confirmOrderBtn.click();
    }

    public OrderHistoryPage navigateToOrder(){
        LOG.info("Navigate to Order history");
        backToOrdersBtn.click();
        return new OrderHistoryPage(webDriver);
    }

    String getReference(){
        String reference = orderConfirmationBox.getText();
        reference = reference.substring(reference.indexOf("reference ") + 10, reference.indexOf(" in "));
        return reference;
    }

}
