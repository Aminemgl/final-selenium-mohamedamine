package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    private By productTitle = By.cssSelector(".a-size-medium.sc-product-title.a-text-bold");
    private By quantity = By.cssSelector("span.a-dropdown-prompt");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        WebElement titleElement = driver.findElement(productTitle);
        return titleElement.getText().trim();
    }

    public int getQuantity() {
        WebElement quantityElement = driver.findElement(quantity);
        return Integer.parseInt(quantityElement.getText().trim());
    }
}
