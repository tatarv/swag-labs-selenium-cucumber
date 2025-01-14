package steps;

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

    @Given("que eu acesso a aplicação")
    public void que_eu_acesso_a_aplicacao() {
        String driverPath = System.getenv("driverPath");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
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
}
