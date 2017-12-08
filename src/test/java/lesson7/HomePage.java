package lesson7;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    static WebDriver webDriver;

    @FindBy(id = "search_query_top")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-default button-search']")
    WebElement searchButton;

    HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SearchResultsPage enterSearchCriteria(String searchCriteria){
        searchInput.clear();
        searchInput.sendKeys(searchCriteria);
        searchButton.click();
        return new SearchResultsPage(webDriver);
    }
}
