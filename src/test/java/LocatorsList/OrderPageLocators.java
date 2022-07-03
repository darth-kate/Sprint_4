package LocatorsList;
import org.openqa.selenium.By;

public class OrderPageLocators {
    //Кнопка Далее - findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM"))

    //Поле Имя - findElements(By.xpath(".//div[@class='Order_Form__17u6u']/div[@placeholder='* Имя']"))

    //Поле Фамилия - findElements(By.xpath(".//div[@class='Order_Form__17u6u']/div[@placeholder='* Фамилия']"))

    //Поле Адрес findElements(By.xpath(".//div[@class='Order_Form__17u6u']/div[@placeholder='* Адрес: куда привезти заказ']"))

    //Станция метро findElement(By.className("select-search__input"))

    //Выпадашка для поля станций метро findElement(By.className("select-search__select"))

    //Список станций - дождаться появления - findElement(By.className("select-search__options"))

    //Выбор метро Красносельская - findElement(By.xpath("//div[@class='select-search__select'/ul/li[5]"))

    //Поле Телефон findElements(By.xpath("//div[@class='Order_Form__17u6u']/div[@placeholder='* Телефон: на него позвонит курьер']"))

    //Кнопка Заказать на втором шаге заполнения findElement(By.className("Button_Button__ra12g Button_Middle__1CSJM"))

    //Поле Когда привезти самокат findElement(By.className("Order_Icon__U8ltz"))

    //Сегодняшняя дата - findElement(By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]"))

    //Поле Срок аренды - findElement(By.className("Dropdown-control"))

    //Четвертый вариант срока аренды - findElement(By.xpath(".//div[@class='Dropdown-menu']/div[4]"))

    //Чекбокс цвета самоката - черный жемчуг - findElement(By.id("black"))

    //Чекбокс цвета самоката - серая безысходность - findElement(By.id("grey"))

    //Поле Комментарий для курьера - findElement(By.xpath(".//div[2]/div[@class='Input_InputContainer__3NykH']/input))

    //Кнопка Да в попапе Оформить заказ - findElement(By.xpath(".//div[@class='Order_Modal__YZ-d3']/*/button[@class='Button_Button__ra12g Button_Middle__1CSJM']"))

    //Попап Заказ оформлен - findElement(By.className("Order_ModalHeader__3FDaJ")).getText() - должен быть "Заказ оформлен"
}
