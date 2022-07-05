package pageobject;
import dataforpo.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class OrderPageScooter {
    Order order;
    private WebDriver driver;

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
        this.order = new Order(driver);
    }

    public By nameField = By.xpath(".//input[@placeholder='* Имя']");
    public By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    public By addressField= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public By metroField = By.className("select-search__input");
    public By stationsList = By.className("select-search__options");
    public By krasnoselskayaStation = By.xpath(".//div/div[2]/ul/li[@data-value='5']");
    public By continueButton = By.xpath(".//button[text()='Далее']");
    public By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    public By whenToOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By todayDateOnCalendar = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    public By rentalTerm = By.className("Dropdown-control");
    public By dropdown4th = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
    public By blackCheckbox = By.id("black");
    public By commentaryField = By.xpath(".//div[2]/div[@class='Input_InputContainer__3NykH']/input");
    public By yesButton = By.xpath(".//button[text()='Да']");
    public By orderSuccessPopup = By.xpath(".//button[text()='Посмотреть статус']");

    public void sendKeysToOrderFields(String name, String surname, String address, String phone, String commentary){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name); // order.names[0]
        driver.findElement(surnameField).sendKeys(surname); // order.surnames[0]
        driver.findElement(addressField).sendKeys(address); // order.addresses[0]
        driver.findElement(metroField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stationsList));
        driver.findElement(krasnoselskayaStation).click();
        driver.findElement(telephoneField).sendKeys(phone); // order.telephones[0]
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
        clickOnOrderButton();//order.commentary
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

        assertEquals("Ожидается появление кнопки - Посмотреть статус", true, driver.findElement(orderSuccessPopup).isDisplayed());
    }
}
