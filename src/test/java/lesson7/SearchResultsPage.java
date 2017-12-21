package lesson7;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.util.List;

public class SearchResultsPage {
    static WebDriver webDriver;


    SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public ExpectedCondition<Boolean> listNthElementHasText(int elemNum, By locator, String searchText){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver){
                List<WebElement> list = webDriver.findElements(locator);
                try {
                    list.get(elemNum);
                    return list.get(elemNum).getText().equals(searchText);
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }
        };
    }

    public ExpectedCondition<Boolean> pageIsLoaded(String titleName, String url){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                return (webDriver.getTitle().contains(titleName)&&webDriver.getCurrentUrl().contains(url));
            }
        };
    }

    public ExpectedCondition<Boolean> stalenessOfElement(By locator){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                try {
                    return (webDriver.findElements(locator).size() == 0);
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }
        };
    }

}
