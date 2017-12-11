package lesson8;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//table[@id='order-list']//a[@class='color-myaccount']")
    WebElement reference;

    @FindBy(xpath = "//td[@class='bold']")
    WebElement productName;

    OrderHistoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    String getReference(){
        LOG.info("Get reference of the last product");
        return reference.getText();
    }

    String productThatWasBought(){
        LOG.info("Get name of last product");
        reference.click();
        return productName.getText();
    }

}
