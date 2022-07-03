import PageObject.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckDropdownFaq {
    private WebDriver driver;
    @Test
    public void testChrome() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAndCheckAnswers();
    }
    @After
    public void teardownChrome() {
        driver.quit();
    }
    @Test
    public void testFirefox() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.closeCookiePopup();
        objHomePage.scrollUntilFaqList();

        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAndCheckAnswers();

    }
    @After
    public void teardownFirefox() {
        driver.quit();
    }
}
