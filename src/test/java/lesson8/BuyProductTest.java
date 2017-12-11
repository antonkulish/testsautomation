package lesson8;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BuyProductTest extends BasePage{

    protected String username = "kulan888@gmail.com";
    protected String password = "Fynjirf888";
    protected String searchCriteria = "Blouse";


    @Test
    public void productCanBeBoughtThroughTheCart(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(username, password);
        SearchResultsPage searchResultsPage = accountPage.searchProduct(searchCriteria);
        String productThatWillBeBought = searchResultsPage.productName.getText();
        searchResultsPage.clickAddToCartBtn();
        ShoppingCartPage shoppingCartPage = searchResultsPage.navigateToCart();
        shoppingCartPage.confirmBuyingThroughTheCart();
        String expectedReference = shoppingCartPage.getReference();
        OrderHistoryPage orderHistoryPage = shoppingCartPage.navigateToOrder();
        String actualReference = orderHistoryPage.getReference();
        String productThatWasBought = orderHistoryPage.productThatWasBought();
        Assert.assertTrue(actualReference.equals(expectedReference));
        Assert.assertTrue(productThatWasBought.contains(productThatWillBeBought));
    }
}
