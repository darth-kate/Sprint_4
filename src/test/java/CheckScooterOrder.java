import datafortests.ScooterUrls;
import datafortests.Order;
import org.junit.Before;
import pageobject.HomePageScooter;
import pageobject.OrderPageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;

public class CheckScooterOrder {
    private WebDriver driver;
    Order order;

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ScooterUrls.HOME_URL);
    }

    @Test
    public void testHeaderOrderButtonShortFields() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Order order = new Order();
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.sendKeysToOrderFields(order.NAMES[0], order.SURNAMES[0], order.ADDRESSES[0], order.TELEPHONES[0], null);
        objOrderPage.checkOrderSuccessPopup();
    }

    @Test
    public void testHeaderOrderButtonLongFields() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Order order = new Order();
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.sendKeysToOrderFields(order.NAMES[1], order.SURNAMES[1], order.ADDRESSES[1], order.TELEPHONES[1], order.COMMENTARY);
        objOrderPage.checkOrderSuccessPopup();
    }
    @Test
    public void testBottomOrderButtonLongFields() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Order order = new Order();
        objHomePage.closeCookiePopup();
        objHomePage.clickOnBottomOrderButton();
        objOrderPage.sendKeysToOrderFields(order.NAMES[1], order.SURNAMES[1], order.ADDRESSES[1], order.TELEPHONES[1], order.COMMENTARY);
        objOrderPage.checkOrderSuccessPopup();
    }

    /*
    @Test
    public void testFirefoxHeaderOrderButtonShortFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get(ScooterHomePageURL.HOME_URL);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsShort();
        objOrderPage.secondPageFieldsWithoutCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();

    }
    @Test
    public void testFirefoxHeaderOrderButtonLongFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get(ScooterHomePageURL.HOME_URL);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }

    @Test
    public void testFirefoxBottomOrderButtonLongFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get(ScooterHomePageURL.HOME_URL);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnBottomOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    */

    @After
    public void teardown() {
        driver.quit();
    }
}
