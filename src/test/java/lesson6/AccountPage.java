package lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    static WebDriver webDriver;

    @FindBy(className = "logout")
    WebElement logOut;

    @FindBy(xpath = "//h1[contains(.,('My account'))]")
    WebElement accountPageTitle;

    AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage signOut(){
        logOut.click();
        return new LoginPage(webDriver);
    }
}
