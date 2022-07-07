package pageobject;
import dataforpo.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderPageScooter {
    private WebDriver driver;

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }

    //поле Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //поле Фамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле Адрес
    private By addressField= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле Номер телефона
    private By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //поле для ввода станции метро
    private By metroField = By.className("select-search__input");
    //Выпадающий список станций метро
    private By stationsList = By.className("select-search__options");
    //Локатор станции метро Красносельская в списке станций
    private By krasnoselskayaStation = By.xpath(".//div/div[2]/ul/li[@data-value='5']");
    //кнопка продолжить на первой странице оформления заказа
    private By continueButton = By.xpath(".//button[text()='Далее']");
    //кнопка оформления заказа на второй странице оформления заказа
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //поле Когда доставить
    private By whenToOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор сегодняшней даты в календаре
    private By todayDateOnCalendar = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    //дропдаун срока аренды
    private By rentalTerm = By.className("Dropdown-control");
    //четвертый вариант в дропдауне срока аренды
    private By dropdown4th = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
    //чекбокс черного цвета самоката
    private By blackCheckbox = By.id("black");
    //поле Комментарий к заказу
    private By commentaryField = By.xpath(".//div[2]/div[@class='Input_InputContainer__3NykH']/input");
    //кнопка Да в попапе подтверждения заказа
    private By yesButton = By.xpath(".//button[text()='Да']");
    //локатор попапа успешного совершения заказа
    private By orderSuccessPopup = By.xpath(".//button[text()='Посмотреть статус']");

    public void sendKeysToOrderFields(String name, String surname, String address, String phone, String commentary){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name); // order.NAMES[0]
        driver.findElement(surnameField).sendKeys(surname); // order.SURNAMES[0]
        driver.findElement(addressField).sendKeys(address); // order.ADDRESSES[0]
        driver.findElement(metroField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stationsList));
        driver.findElement(krasnoselskayaStation).click();
        driver.findElement(telephoneField).sendKeys(phone); // order.TELEPHONES[0]
        clickOnContinueButton();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(whenToOrder));
        driver.findElement(whenToOrder).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(todayDateOnCalendar));
        driver.findElement(todayDateOnCalendar).click();
        driver.findElement(rentalTerm).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(dropdown4th));
        driver.findElement(dropdown4th).click();
        driver.findElement(blackCheckbox).click();
        driver.findElement(commentaryField).sendKeys(commentary);
        clickOnOrderButton();//order.COMMENTARY
    }

    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void clickOnOrderButton(){
        driver.findElement(orderButton).click();
        ClickOnYesButton();
    }

    public void ClickOnYesButton(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
    }

    public void checkOrderSuccessPopup(){

        assertTrue("Ожидается появление кнопки - Посмотреть статус", driver.findElement(orderSuccessPopup).isDisplayed());
    }
}
