import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Roman on 27.06.2017.
 */
public class Page {
    WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public boolean isElementDisplayed(By selector) {
        try {
            WebElement el = driver.findElement(selector);
            return el.isDisplayed();
        }
        catch (NoSuchElementException i){
            return false;
        }
    }



    public void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
