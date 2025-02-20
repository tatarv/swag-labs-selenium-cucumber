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
    public void usernameBranco(){
        loginElements.usernameField.clear();
    }
    public void passwordBranco(){
        loginElements.passwordField.clear();
    }
    public void preencherUsername(String username) {
        loginElements.usernameField.sendKeys(username);
    }
    public void preencherPassword(String password) {
        loginElements.passwordField.sendKeys(password);
    }
    public void mostrarMensagem(String mensagem) {
        String mensagemAtual = loginElements.errorMessageContainer.getText().trim();
        System.out.printf(mensagemAtual);
        mensagemAtual.contains(mensagem);
    }
}
