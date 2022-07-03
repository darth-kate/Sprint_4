import PageObject.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckLogoYandexScooter {
    private WebDriver driver;
    @Test
    public void testIsHomePageOnScooterLogoClick() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOnHeaderOrderButton();
        assertEquals("При клике по кнопке Заказать должен происходить переход на страницу заказа", "https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());
        objHomePage.clickOnScooterLogo();
    }
    @After
    public void teardownChromeScooterLogoClick() {
        driver.quit();
    }

    @Test
    public void testIsYandexPageOnYandexLogoClick() {
        WebDriverManager.chromedriver().setup();
        // создаем драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переходим на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOnYandexLogo();
    }
    @After
    public void teardownChromeYandexLogoClick() {
        driver.quit();
    }
}
