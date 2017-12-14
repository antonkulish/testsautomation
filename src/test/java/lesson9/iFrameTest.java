package lesson9;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class iFrameTest extends BaseTest{
    @Test
    public void checkLinkTextInIFrame(){
        HomePage homePage = new HomePage(webDriver);
        homePage.scrollToElement();
        webDriver.switchTo().frame(homePage.iFrame);
        Assert.assertEquals("PrestaShop", webDriver.findElement(By.xpath("//a[@title='PrestaShop']")).getText());
    }
}
