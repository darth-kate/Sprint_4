package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class OrderPageScooter {
    private WebDriver driver;

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }

    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By metroField = By.className("select-search__input");
    private By stationsList = By.className("select-search__options");
    private By krasnoselskayaStation = By.xpath(".//div/div[2]/ul/li[@data-value='5']");
    private By continueButton = By.xpath(".//button[text()='Далее']");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By whenToOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By todayDateOnCalendar = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    private By rentalTerm = By.className("Dropdown-control");
    private By dropdown4th = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
    private By blackCheckbox = By.id("black");
    private By commentaryField = By.xpath(".//div[2]/div[@class='Input_InputContainer__3NykH']/input");
    private By yesButton = By.xpath(".//button[text()='Да']");
    private By orderSuccessPopup = By.xpath(".//button[text()='Посмотреть статус']");

    private String[] names = new String[]{
            "Ян",
            "Гайнельмухаммет"
    };

    private String[] surnames = new String[]{
            "Гэ",
            "Иванов"
    };

    private String[] addresses = new String[]{
            "5штук",
            "5штук5штук5штук5штук5штук5штук5штук5штук5штук5шту"
    };

    private String[] telephones = new String[]{
            "12345678901",
            "1234567890123"
    };

    private String commentary = "Комментарий для курьера необязательный";

    public void firstPageFieldsShort(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(names[0]);
        driver.findElement(surnameField).sendKeys(surnames[0]);
        driver.findElement(addressField).sendKeys(addresses[0]);
        driver.findElement(metroField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stationsList));
        driver.findElement(krasnoselskayaStation).click();
        driver.findElement(telephoneField).sendKeys(telephones[0]);
        clickOnContinueButton();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void firstPageFieldsLong(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(names[1]);
        driver.findElement(surnameField).sendKeys(surnames[1]);
        driver.findElement(addressField).sendKeys(addresses[1]);
        driver.findElement(telephoneField).sendKeys(telephones[1]);
        driver.findElement(metroField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(stationsList));
        driver.findElement(krasnoselskayaStation).click();
        clickOnContinueButton();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void secondPageFieldsWithoutCommentary(){
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
    }

    public void secondPageFieldsWithCommentary(){
        secondPageFieldsWithoutCommentary();
        driver.findElement(commentaryField).sendKeys(commentary);

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
