import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Roman on 27.06.2017.
 */
public class ChooseTypePage extends Page {

    public final By CHOOSE_TYPE_POPUP = By.cssSelector("div.choose-type");
    public final By TENANT_RADIO_BUTTON = By.id("Tenant");
    public final By LANDLORD_RADIO_BUTTON = By.id("Landlord");
    public final By LOGIN_LINK = By.xpath(".//div[@class='choose-type']//a[.='Login']");
    public final By LOGIN_POPUP = By.xpath(".//div[@class = 'login']/h2[.='Log In']");

    public ChooseTypePage (WebDriver driver){
        super(driver);
    }

    public boolean isChooseTypePopupDisplayed() {
        return isElementDisplayed(CHOOSE_TYPE_POPUP);
    }

    public void clickOnTenantRadioButton() {
            click(TENANT_RADIO_BUTTON);
    }
    public void clickOnLandlordRadioButton() {
        click(LANDLORD_RADIO_BUTTON);
    }

    public void clickLoginLink() {
        click(LOGIN_LINK);
    }
    public boolean isLoginPopupDisplayed() {
        return isElementDisplayed(LOGIN_POPUP);
    }
}
