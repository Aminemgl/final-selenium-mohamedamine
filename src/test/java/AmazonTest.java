import java.util.concurrent.TransferQueue;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AmazonHomePage;
import pageobjects.CartPage;
import pageobjects.AmazonHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MeilleuresVentesPage;
import pageobjects.ProductPage;

public class AmazonTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test
    public void testAddToCart() {
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        driver.get("https://www.amazon.fr/");
        amazonHomePage.closeCookiePopup();
        MeilleuresVentesPage meilleuresVentesPage;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        meilleuresVentesPage = amazonHomePage.openmeilleuresVentes();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        meilleuresVentesPage.openHighTech();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ProductPage productPage = meilleuresVentesPage.openThirdProduct();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productPage.changeQuantity(2);
        productPage.addToCart();
        CartPage cartPage = new CartPage(driver);
        driver.get("https://www.amazon.fr/gp/cart/view.html/ref=nav_cart");
        Assert.assertEquals(2, cartPage.getQuantity());
    }
}