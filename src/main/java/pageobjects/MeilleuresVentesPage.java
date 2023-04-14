package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MeilleuresVentesPage {

    private WebDriver driver;

    private By highTechLink = By.cssSelector("a[href*='/gp/bestsellers/electronics/ref=zg_bs_nav_0']");

    public MeilleuresVentesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHighTech() {
        WebElement link = driver.findElement(highTechLink);
        link.click();
    }

    public ProductPage openThirdProduct() {
        // select the third product not sponsored
        WebElement product = driver.findElements(By.cssSelector(".a-section.a-text-center.sponsored-products")).get(3);
        product.click();
        return new ProductPage(driver);
    }
}
