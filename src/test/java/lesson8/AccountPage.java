package lesson8;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(id = "search_query_top")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-default button-search']")
    WebElement searchButton;

    AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SearchResultsPage searchProduct(String searchCriteria){
        LOG.info("Enter search criteria '" + searchCriteria + "' and search product");
        searchInput.clear();
        searchInput.sendKeys(searchCriteria);
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }

}
