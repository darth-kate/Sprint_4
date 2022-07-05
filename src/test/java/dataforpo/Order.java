package dataforpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Order {
    private WebDriver driver;
    public Order(WebDriver driver){
        this.driver = driver;
    }

    public String[] names = new String[]{
            "Ян",
            "Гайнельмухаммет"
    };

    public String[] surnames = new String[]{
            "Гэ",
            "Иванов"
    };

    public String[] addresses = new String[]{
            "5штук",
            "5штук5штук5штук5штук5штук5штук5штук5штук5штук5шту"
    };

    public String[] telephones = new String[]{
            "12345678901",
            "1234567890123"
    };

    public String commentary = "Комментарий для курьера необязательный";

}
