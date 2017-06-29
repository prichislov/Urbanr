import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman on 28.06.2017.
 */
public class ChooseTypeTest {

    public static final String USERNAME = "prichislov";
    public static final String ACCESS_KEY = "d6aafea3-2d1e-4a7e-8853-dbbc95a4c145";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";


    private WebDriver driver;
    private HomePage homePage;
    private ChooseTypePage chooseTypePage;
    private SingUpPage singUpPage;

    @BeforeTest
    public void setUp() throws Exception{
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability("platform", "macOS 10.12");
//        caps.setCapability("version", "59.0");
////        caps.setCapability("name", "Test: openLoginLink");
//
//        driver = new RemoteWebDriver(new URL(URL), caps);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openPage() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://urbanr.com");
        homePage = new HomePage(driver);
        chooseTypePage = new ChooseTypePage(driver);
        singUpPage = new SingUpPage(driver);
    }

//     TC_SU_01 Open Choose type Sing Up popup
    @Test
    public void openChooseRolePopup(){
        homePage.clickOnSignUp();
        Assert.assertTrue(chooseTypePage.isChooseTypePopupDisplayed(), " Choose type popup is not opened !!!");
    }
//     TC_SU_02  “Tenant” role selection
    @Test
    public void tenantRoleSelection() {
        homePage.clickOnSignUp();
        chooseTypePage.clickOnTenantRadioButton();
        Assert.assertTrue(singUpPage.isSingUpPopupDisplayed()," Sing Up popup is not opened !!!");
    }
//     TC_SU_03 “Landlord” role selection
    @Test
    public void landlordRoleSelection() {
        homePage.clickOnSignUp();
        chooseTypePage.clickOnLandlordRadioButton();
        Assert.assertTrue(singUpPage.isSingUpPopupDisplayed()," Sing Up popup is not opened !!!!");
    }
//     TC_SU_04  Moving to Log In popup by clicking on “Log in” link
    @Test
    public void openLoginLink() {
        homePage.clickOnSignUp();
        chooseTypePage.clickLoginLink();
        Assert.assertTrue(chooseTypePage.isLoginPopupDisplayed()," Log In popup is opened !!!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}


