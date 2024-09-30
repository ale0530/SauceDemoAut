java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']//following-sibling::button")).click();
    }
}