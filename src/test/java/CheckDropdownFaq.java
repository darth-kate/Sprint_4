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
    public void testFirstQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[0], objHomePage.answers[0], objHomePage.messages[0], objHomePage.expected[0]);
    }
    @Test
    public void testSecondQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[1], objHomePage.answers[1], objHomePage.messages[1], objHomePage.expected[1]);
    }
    @Test
    public void testThirdQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[2], objHomePage.answers[2], objHomePage.messages[2], objHomePage.expected[2]);
    }
    @Test
    public void testFourthQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[3], objHomePage.answers[3], objHomePage.messages[3], objHomePage.expected[3]);
    }
    @Test
    public void testFifthQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[4], objHomePage.answers[4], objHomePage.messages[4], objHomePage.expected[4]);
    }
    @Test
    public void testSixthQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[5], objHomePage.answers[5], objHomePage.messages[5], objHomePage.expected[5]);
    }
    @Test
    public void testSeventhQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[6], objHomePage.answers[6], objHomePage.messages[6], objHomePage.expected[6]);
    }
    @Test
    public void testEighthQuestion() {
        // создание объекта класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.closeCookiePopup();
        //проводим тест на соответствие ответов ожидаемым строкам
        objHomePage.clickOnQuestionsAnswers(objHomePage.questions[7], objHomePage.answers[7], objHomePage.messages[7], objHomePage.expected[7]);
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
