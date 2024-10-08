java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getItemCount() {
        return driver.findElements(By.className("cart_item")).size();
    }
    
    public void removeFromCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']//following-sibling::button[text()='Remove']")).click();
    }
}