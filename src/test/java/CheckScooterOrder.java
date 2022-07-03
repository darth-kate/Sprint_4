import PageObject.HomePageScooter;
import PageObject.OrderPageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckScooterOrder {
    private WebDriver driver;
    @Test
    public void testChromeHeaderOrderButtonShortFields() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsShort();
        objOrderPage.secondPageFieldsWithoutCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    @After
    public void teardownChromeOrderButtonShortFields() {
        driver.quit();
    }

    @Test
    public void testChromeHeaderOrderButtonLongFields() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    @After
    public void teardownChromeOrderButtonLongFields() {
        driver.quit();
    }

    @Test
    public void testChromeBottomOrderButtonLongFields() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnBottomOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    @After
    public void teardownChromeBottomOrderButtonLongFields() {
        driver.quit();
    }


    @Test
    public void testFirefoxHeaderOrderButtonShortFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsShort();
        objOrderPage.secondPageFieldsWithoutCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();

    }
    @After
    public void teardownFirefoxOrderButtonShortFields() {
        driver.quit();
    }

    @Test
    public void testFirefoxHeaderOrderButtonLongFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnHeaderOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    @After
    public void teardownFirefoxOrderButtonLongFields() {
        driver.quit();
    }

    @Test
    public void testFirefoxBottomOrderButtonLongFields() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objHomePage.closeCookiePopup();
        objHomePage.clickOnBottomOrderButton();
        objOrderPage.firstPageFieldsLong();
        objOrderPage.secondPageFieldsWithCommentary();
        objOrderPage.clickOnOrderButton();
        objOrderPage.checkOrderSuccessPopup();
    }
    @After
    public void teardownFirefoxBottomOrderButtonLongFields() {
        driver.quit();
    }
}
