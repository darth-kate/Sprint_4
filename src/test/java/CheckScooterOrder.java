import dataforpo.ScooterUrls;
import dataforpo.Order;
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
        Order order = new Order(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.sendKeysToOrderFields(order.names[0], order.surnames[0], order.addresses[0], order.telephones[0], null);
        objOrderPage.checkOrderSuccessPopup();
    }

    @Test
    public void testHeaderOrderButtonLongFields() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Order order = new Order(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.sendKeysToOrderFields(order.names[1], order.surnames[1], order.addresses[1], order.telephones[1], order.commentary);
        objOrderPage.checkOrderSuccessPopup();
    }
    @Test
    public void testBottomOrderButtonLongFields() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        Order order = new Order(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnBottomOrderButton();
        objOrderPage.sendKeysToOrderFields(order.names[1], order.surnames[1], order.addresses[1], order.telephones[1], order.commentary);
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
