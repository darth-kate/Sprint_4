package pageobject;
import dataforpo.HomePage;
import dataforpo.ScooterUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class HomePageScooter {
    HomePage homePage;
    private WebDriver driver;
    public HomePageScooter(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
    }

    //метод скролла страницы до блока FAQ - скроллим до последнего вопроса
    public void scrollUntilFaqList(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(homePage.questions[homePage.questions.length-1]));
    }

    //метод закрытия окна с куками
    public void closeCookiePopup(){
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    //метод с циклом для прохода по массивам вопросов, ответов, ожидаемых текстов и ошибок
    //для каждого вопроса происходит клик, ожиданеи видимости ответа с тем же индексом,
    //а после - сравнение текста из тега ответа с ожидаемым с тем же индесом
    //каждый раз подскролливаем страницу до последнего вопроса - если вызвать скролл единожды, то последний вопрос не будет кликабелен
    public void clickOnQuestionsAndCheckAnswers() {
        for (int i = 0; i < homePage.questions.length; i++) {
            driver.findElement(homePage.questions[i]).click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(homePage.answers[i]));
            assertEquals(homePage.message[i], homePage.expected[i], driver.findElement(homePage.answers[i]).getText());
            //System.out.println(driver.findElement(questions[i]));
            //System.out.println(driver.findElement(answers[i]));
            scrollUntilFaqList();
        }
    }

    //метод клика на кнопку Заказать в шапке
    public void clickOnHeaderOrderButton(){
        driver.findElement(homePage.orderButtonHeader).click();
    }

    //метод клика на кнопку Заказать внизу страницы
    public void clickOnBottomOrderButton(){
        scrollUntilBottomOrderButton();
        driver.findElement(homePage.orderButtonOnPage).click();
    }

    //скролл до кнопки заказа внизу страницы
    public void scrollUntilBottomOrderButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[text()='Как это работает']")));
    }

    public void checkYandexPageOnClickYandexLogo(){
        driver.findElement(homePage.yandexLogo).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        assertEquals("При клике по логотипу Яндекса должно происходить открытие главной страницы Яндекса в новой вкладке", ScooterUrls.YANDEX_URL, driver.getCurrentUrl());
    }

    public void checkHomePageOnClickOnScooterLogo(){
        driver.findElement(homePage.scooterLogo).click();
        new WebDriverWait(driver, 3);
        assertEquals("При клике по логотипу Самокат должен происходить переход на главную страницу", ScooterUrls.HOME_URL, driver.getCurrentUrl());
    }
}
