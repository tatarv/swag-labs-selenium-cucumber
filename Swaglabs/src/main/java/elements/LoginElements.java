package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginElements {

    //campos de texto
    @FindBy(id = "user-name")
    public static WebElement usernameField;

    @FindBy (id = "password")
    public static WebElement passwordField;

    //butões
    @FindBy (id = "login-button")
    public static WebElement loginButton;

    //mensagens
    @FindBy(xpath = "//*[@data-test='error']")
    public WebElement errorMessageContainer;
}
