package lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    static WebDriver webDriver;

    @FindBy(className = "login")
    WebElement logInBtn;

    HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage openLoginPage(){
        logInBtn.click();
        return new LoginPage(webDriver);
    }
}
