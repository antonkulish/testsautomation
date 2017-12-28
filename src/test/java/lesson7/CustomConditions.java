package lesson7;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.List;

public class CustomConditions {

    static WebDriver webDriver;
    static WebDriverWait wait;

    CustomConditions(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
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

    public ExpectedCondition<Boolean> stalenessOfElement(WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                try {
                    return (element.isDisplayed() == false);
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }
        };
    }
}
