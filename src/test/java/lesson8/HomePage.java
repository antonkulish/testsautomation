package lesson8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage {
    private static final Logger LOG = LogManager.getLogger(HomePage.class);

    static WebDriver webDriver;

    @FindBy(className = "login")
    WebElement logInBtn;

    HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage openLoginPage(){
        LOG.info("Open Login page");
        logInBtn.click();
        return new LoginPage(webDriver);
    }
}
