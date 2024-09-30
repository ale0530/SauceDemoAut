java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority = 1)
    public void testAddSingleProductToCart() {
        productsPage.addToCart("Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getItemCount(), 1);
    }

    @Test(priority = 2)
    public void testAddMultipleProductsToCart() {
        productsPage.addToCart("Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getItemCount(), 2);
        
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(cartPage.getItemCount(), 3);
    }

    @Test(priority = 3)
    public void testRemoveProductFromCart() {
        cartPage.removeFromCart("Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getItemCount(), 2);
    }

    @Test(priority = 4)
    public void testEmptyCart() {
        cartPage.removeFromCart("Sauce Labs Bike Light");
        cartPage.removeFromCart("Sauce Labs Fleece Jacket");
        
        Assert.assertEquals(cartPage.getItemCount(), 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}