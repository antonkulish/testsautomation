package lesson7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        return(ExpectedConditions.and(
                ExpectedConditions.titleContains(titleName),
                ExpectedConditions.urlContains(url)
        ));
    }

    public ExpectedCondition<Boolean> stalenessOfElement(By locator){
        return ExpectedConditions.invisibilityOfElementLocated(locator);
    }

}
