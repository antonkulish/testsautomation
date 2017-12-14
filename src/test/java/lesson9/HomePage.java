package lesson9;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(xpath = "//iframe[@title='fb:like_box Facebook Social Plugin']")
    WebElement iFrame;


    HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void scrollToElement(){
        LOG.info("Scroll down to frame");
        WebDriverWait wait = new WebDriverWait(webDriver, 5, 200);
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("arguments[0].scrollIntoView(true);", iFrame);
        wait.until(ExpectedConditions.elementToBeClickable(iFrame));
    }
}
