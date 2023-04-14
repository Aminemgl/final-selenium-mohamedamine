package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonHomePage {

    private WebDriver driver;

    private By cookiePopup = By.id("sp-cc-accept");
    private By meilleuresVentes = By.cssSelector("a[href*='/gp/bestsellers/?ref_=nav_cs_bestsellers']");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCookiePopup() {
        WebElement popup = driver.findElement(cookiePopup);
        popup.click();
    }

    public MeilleuresVentesPage openmeilleuresVentes() {
        WebElement link = driver.findElement(meilleuresVentes);
        link.click();
        return new MeilleuresVentesPage(driver);
    }
}