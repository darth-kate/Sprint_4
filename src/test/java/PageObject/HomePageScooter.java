package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageScooter {
    public HomePageScooter(WebDriver driver){
        this.driver = driver;
        this.initData();
    }
    private WebDriver driver;
    // локаторы для полей на главной странице
    private By orderButtonHeader = By.xpath(".//div/div/div[1]/div[2]//button[text()='Заказать']");
    private By orderButtonOnPage = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM')]");
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    private String homeUrl = "https://qa-scooter.praktikum-services.ru/";
    private String yandexUrl = "https://yandex.ru/";

    private By[] questions = new By[8];
    private By[] answers = new By[8];
    private String[] message = new String[]{
            "Первый ответ не равен строке: Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Второй ответ не равен строке: Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Третий ответ не равен строке: Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Четвертый ответ не равен строке: Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пятый ответ не равен строке: Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Шестой ответ не равен строке: Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Седьмой ответ не равен строке: Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Восьмой ответ не равен строке: Да, обязательно. Всем самокатов! И Москве, и Московской области.",
    };
    private String[] expected = new String[]{
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    //Заполнение массивов локаторов для вопросов и ответов блока FAQ
    // для questions заполняем с 1 по 8 индексы div
    // для answers заполняем с 0 по 7 индексы id
    private void initData() {
        for (int i = 0; i <= 7; i++) {
            questions[i] = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[" + (i + 1) + "]");
            answers[i] = By.xpath("//div[@id='accordion__panel-" + i + "']/p");
        }
    }

    //метод скролла страницы до блока FAQ - скроллим до последнего вопроса
    public void scrollUntilFaqList(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questions[questions.length-1]));
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
        for (int i = 0; i < questions.length; i++) {
            driver.findElement(questions[i]).click();
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answers[i]));
            assertEquals(message[i], expected[i], driver.findElement(answers[i]).getText());
            //System.out.println(driver.findElement(questions[i]));
            //System.out.println(driver.findElement(answers[i]));
            scrollUntilFaqList();
        }
    }

    //метод клика на кнопку Заказать в шапке
    public void clickOnHeaderOrderButton(){
        driver.findElement(orderButtonHeader).click();

    }

    //метод клика на кнопку Заказать внизу страницы
    public void clickOnBottomOrderButton(){
        scrollUntilBottomOrderButton();
        driver.findElement(orderButtonOnPage).click();
    }

    //скролл до кнопки заказа внизу страницы
    public void scrollUntilBottomOrderButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[text()='Как это работает']")));
    }

    public void clickOnYandexLogo(){
        driver.findElement(yandexLogo).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        assertEquals("При клике по логотипу Яндекса должно происходить открытие главной страницы Яндекса в новой вкладке", yandexUrl, driver.getCurrentUrl());
    }

    public void clickOnScooterLogo(){
        driver.findElement(scooterLogo).click();
        new WebDriverWait(driver, 3);
        assertEquals("При клике по логотипу Самокат должен происходить переход на главную страницу", homeUrl, driver.getCurrentUrl());
    }
}
