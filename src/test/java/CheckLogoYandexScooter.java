import dataforpo.ScooterUrls;
import org.junit.Before;
import pageobject.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckLogoYandexScooter {
    private WebDriver driver;

    @Before
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ScooterUrls.HOME_URL);
    }
    @Test
    public void testIsHomePageOnScooterLogoClick() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOnHeaderOrderButton();
        assertEquals("При клике по кнопке Заказать должен происходить переход на страницу заказа", ScooterUrls.ORDER_URL, driver.getCurrentUrl());
        objHomePage.checkHomePageOnClickOnScooterLogo();
    }

    @Test
    public void testIsYandexPageOnYandexLogoClick() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.checkYandexPageOnClickYandexLogo();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
