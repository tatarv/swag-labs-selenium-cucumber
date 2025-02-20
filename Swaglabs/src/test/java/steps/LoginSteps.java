package steps;

import browser.GoogleChrome;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        // Inicializa o WebDriver antes de cada cenário
        driver = GoogleChrome.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("que eu acesso a aplicação")
    public void que_eu_acesso_a_aplicacao() {
        loginPage.acessarAplicacao();
    }
    @And("eu preencho os campos username e password com um usuário e senha válidos")
    public void euPreenchoOsCamposUsernameEPasswordComUmUsuárioESenhaVálidos() {
        loginPage.preencherUsernamePassword("standard_user","secret_sauce");
    }
    @When("eu clico no botão Login")
    public void euClicoNoBotãoLogin() {
        loginPage.clicarBotaoLogin();
    }
    @Then("a tela principal da aplicação é exibida")
    public void aTelaPrincipalDaAplicaçãoÉExibida() {
        loginPage.acessarTelaPrincipal();
    }
    @And("eu preencho o campo password com uma senha válida")
    public void euPreenchoOCampoPasswordComUmaSenhaVálida() {
        loginPage.preencherPassword("secret_sauce");
    }
    @And("eu não preencho o campo username")
    public void euNãoPreenchoOCampoUsername() {
        loginPage.usernameBranco();
    }
    @Then("uma mensagem de erro é exibida indicando que o campo username é obrigatório")
    public void umaMensagemDeErroÉExibidaIndicandoQueOCampoUsernameÉObrigatório() {
        loginPage.mostrarMensagem("Epic sadface: Username is required");
    }
    @And("eu preencho o campo username com um usuário válido")
    public void euPreenchoOCampoUsernameComUmUsuárioVálido() {
        loginPage.preencherUsername("standard_user");
    }
    @And("eu não preencho o campo password")
    public void euNãoPreenchoOCampoPassword() {
        loginPage.passwordBranco();
    }
    @Then("uma mensagem de erro é exibida indicando que o campo password é obrigatório")
    public void umaMensagemDeErroÉExibidaIndicandoQueOCampoPasswordÉObrigatório() {
        loginPage.mostrarMensagem("Epic sadface: Password is required");
    }

    @And("eu preencho os campos username e password com um usuário e senha diferentes dos que estão listados na tela")
    public void euPreenchoOsCamposUsernameEPasswordComUmUsuárioESenhaDiferentesDosQueEstãoListadosNaTela() {
        loginPage.preencherUsernamePassword("teste","teste");
    }

    @Then("uma mensagem de erro é exibida indicando que o usuário e a senha informados não correspondem a nenhum usuário indicado")
    public void umaMensagemDeErroÉExibidaIndicandoQueOUsuárioEASenhaInformadosNãoCorrespondemANenhumUsuárioIndicado() {
        loginPage.mostrarMensagem("Epic sadface: Username and password do not match any user in this service");
    }

    @After
    public void finalize() {
        // Fecha o navegador após cada cenário
        if (driver != null) {
            GoogleChrome.quitDriver();
        }
    }
}
