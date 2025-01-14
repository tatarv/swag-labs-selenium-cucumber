package pages;

import elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;

public class LoginPage {
    private WebDriver driver;
    private LoginElements loginElements;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginElements = new LoginElements();
        PageFactory.initElements(driver, loginElements);
    }

    public void acessarAplicacao(){

        driver.get("https://www.saucedemo.com/");
    }

    public void preencherUsernamePassword(String username, String password){
        loginElements.usernameField.sendKeys(username);
        loginElements.passwordField.sendKeys(password);
    }

    public void clicarBotaoLogin(){

        loginElements.loginButton.click();
    }

    public void acessarTelaPrincipal(){
        String urlAtual = driver.getCurrentUrl();
        String urlEsperada = "https://www.saucedemo.com/inventory.html";
        assertEquals(urlEsperada,urlAtual);
    }
}
