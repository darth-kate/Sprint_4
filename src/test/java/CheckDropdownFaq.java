import dataforpo.ScooterUrls;
import pageobject.HomePageScooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class CheckDropdownFaq {
    private WebDriver driver;

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ScooterUrls.HOME_URL);
    }
    @Test
    public void testChrome() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAndCheckAnswers();
    }

    /*
    @Test
    public void testFirefox() {
        WebDriverManager.firefoxdriver().setup();
        // создаем драйвер для браузера Firefox
        driver = new FirefoxDriver();
        // переходим на страницу тестового приложения
        driver.get(ScooterHomePageURL.HOME_URL);
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.closeCookiePopup();
        objHomePage.scrollUntilFaqList();

        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAndCheckAnswers();

    }
    */
    @After
    public void teardown() {
        driver.quit();
    }
}
