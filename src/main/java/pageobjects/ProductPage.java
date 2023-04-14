package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    private WebDriver driver;

    private By quantity = By.id("quantity");
    private By addToCartButton = By.id("add-to-cart-button");
    private By productTitle = By.id("productTitle");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeQuantity(int quantityValue) {
        Select quantitySelect = new Select(driver.findElement(quantity));
        quantitySelect.selectByValue(String.valueOf(quantityValue));
    }

    public void addToCart() {
        WebElement button = driver.findElement(addToCartButton);
        button.click();
    }

    public String getTitle() {
        WebElement titleElement = driver.findElement(productTitle);
        return titleElement.getText().trim();
    }
}
