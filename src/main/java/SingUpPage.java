import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Roman on 27.06.2017.
 */
public class SingUpPage extends Page {

    public final By SING_UP_POPUP = By.xpath(".//div[@class = 'singup']/h2[.='Sign Up']");
    public final By CHECKBOX = By.id("i-agree-signup");
    public final By FIRST_NAME_INPUT = By.name("signupFirstName");
    public final By LAST_NAME_INPUT = By.name("signupLastName");
    public final By EMAIL_INPUT = By.name("signupEmail");
    public final By PASSWORD_INPUT = By.name("signupPassword");
    public final By RE_ENTER_PASSWORD_INPUT = By.name("signupReEnterPassword");
    public final By LOGIN_LINK = By.xpath(".//div[@class='form-group web-view']//a[.='Log in!']");
    public final By CANCEL_BUTTON = By.xpath(".//button[@class='btn btn-regular'][.='Cancel']");
    public final By SIGH_UP_BUTTON = By.xpath(".//button[@class='btn btn-emphasized'][text()[contains(.,'Sign Up')]]");
    public final By TERMS_AND_CONDITIONS_LINK = By.xpath(".//label[@for='i-agree-signup']/a");


    public SingUpPage (WebDriver driver){
        super(driver);
    }

    public boolean isSingUpPopupDisplayed() {
        return isElementDisplayed(SING_UP_POPUP);
    }

    public boolean checkboxCondition(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(CHECKBOX));
        return driver.findElement(CHECKBOX).isEnabled();
    }
//              Fill Sing Up Form

    public void fillFirstName(String firsName){
        type(FIRST_NAME_INPUT,firsName);
    }

    public void fillLastName(String lastName){
        type(LAST_NAME_INPUT,lastName);
    }

    public void fillEmail(String email){
        type(EMAIL_INPUT,email);
    }
    public void fillPassword(String pass){
        type(PASSWORD_INPUT,pass);
    }

    public void fillReEnterPassword(String pass){
        type(RE_ENTER_PASSWORD_INPUT,pass);
    }

    public void clickOnSingUpButton(){
        click(SIGH_UP_BUTTON);
    }
    public void clickOnCancelButton() {
        click(CANCEL_BUTTON);
    }
}
