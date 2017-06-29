import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Roman on 27.06.2017.
 */
public class HomePage extends Page {

//    public final By SIGN_UP_LINK = By.xpath(".//div[@class='sign']/a[.='Sign up']");
//    public final By SIGN_UP_LINK = By.xpath(".//div[@class='sign']/a[text()[contains(.,'Sign up')]]");
    public final By SIGN_UP_LINK = By.cssSelector(".sign > a:last-child");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnSignUp() {
        click(SIGN_UP_LINK);
    }

    public boolean isSignUpLinkDisplayed() {
        return isElementDisplayed(SIGN_UP_LINK);
    }
}
