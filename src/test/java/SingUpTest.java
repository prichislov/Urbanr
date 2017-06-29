import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman on 27.06.2017.
 */
public class SingUpTest {

//    public static final String USERNAME = "prichislov";
//    public static final String ACCESS_KEY = "d6aafea3-2d1e-4a7e-8853-dbbc95a4c145";
//    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    WebDriver driver;
    HomePage homePage;
    ChooseTypePage chooseTypePage;
    SingUpPage singUpPage;

    @BeforeTest
   public void setUp() throws Exception{
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability("platform", "macOS 10.12");
//        caps.setCapability("version", "59.0");
//       caps.setCapability("name", "Test: checkboxByDefault");
//
//        driver = new RemoteWebDriver(new URL(URL), caps);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://urbanr.com");
        homePage = new HomePage(driver);
        chooseTypePage = new ChooseTypePage(driver);
        singUpPage = new SingUpPage(driver);
        homePage.clickOnSignUp();
        chooseTypePage.clickOnTenantRadioButton();
    }
//    TC_SU_14   Sign up with all correct fields values when checkbox is not selected

    @Test
    public void checkboxIsNotSelected() throws Exception{
        singUpPage.fillFirstName("John");
        singUpPage.fillLastName("Green");
        singUpPage.fillEmail("jongreen@yopmail.com");
        singUpPage.fillPassword("123456789");
        singUpPage.fillReEnterPassword("123456789");
        singUpPage.clickOnSingUpButton();
        Assert.assertTrue(singUpPage.isSingUpPopupDisplayed()," Successful registration !!! The Sign Up window is closed!!! ");
    }

//    TC_SU_07  Checkbox are not selected by default

    @Test
    public void checkboxByDefault() throws Exception {
        Assert.assertTrue(singUpPage.checkboxCondition()," The 'I agree' checkbox is selected !!! ");
    }

//    TC_SU_08  Cancel registration by clicking on Cancel button

    @Test
    public void cancelRegistrationWithButton () throws Exception{
        singUpPage.clickOnCancelButton();
        Assert.assertTrue(singUpPage.isSingUpPopupDisplayed()," The registration is not cancelled, the Sign Up window is opened !!!");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
