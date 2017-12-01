package lesson5;


import org.openqa.selenium.By;

public interface Locators {
    // LoginTest
    By SIGN_IN_BTN = By.className("login");
    By EMAIL_INPUT = By.id("email");
    By PASS_INPUT = By.id("passwd");
    By SUBMIT_LOGIN_BTN = By.id("SubmitLogin");
    By ACCOUNT_NAME = By.className("account");
    By ORDER_HISTORY_BTN = By.xpath("//a[@title='Orders']/span[contains(.,('Order history and details'))]");
    By ORDER_HISTORY_TITLE = By.xpath("//h1[contains(.,('Order history'))]");
    By CREDIT_SLIPS_BTN = By.xpath("//a[@title='Credit slips']/span[contains(.,('My credit slips'))]");
    By CREDIT_SLIPS_TITLE = By.xpath("//h1[contains(.,('Credit slips'))]");
    By MY_ADDRESSES_BTN = By.xpath("//a[@title='Addresses']/span[contains(.,('My addresses'))]");
    By MY_ADDRESSES_TITLE = By.xpath("//h1[contains(.,('My addresses'))]");
    By MY_PERSONAL_INFO_BTN = By.xpath("//a[@title='Information']/span[contains(.,('My personal information'))]");
    By MY_PERSONAL_INFO_TITLE = By.xpath("//h1[contains(.,('Your personal information'))]");
    By MY_WISHLIST_BTN = By.xpath("//a[@title='My wishlists']/span[contains(.,('My wishlists'))]");
    By MY_WISHLIST_TITLE = By.xpath("//h1[contains(.,('My wishlists'))]");

    //SearchTest
    By SEARCH_INPUT = By.id("search_query_top");
    By SEARCH_BTN = By.xpath("//button[@class='btn btn-default button-search']");
    By COUNT_OF_PRODUCTS = By.className("heading-counter");
    By FIRST_PRODUCT_NAME = By.xpath("//ul[@class='product_list grid row']//li[1]//a[@class='product-name']");
}
