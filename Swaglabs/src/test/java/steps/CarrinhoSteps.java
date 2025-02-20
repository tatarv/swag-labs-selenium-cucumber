package steps;

import browser.GoogleChrome;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarrinhoSteps {
    private WebDriver driver;
    private CarrinhoPage carrinhoPage;

    @Before
    public void setUp() {
        // Inicializa o WebDriver antes de cada cenário
        driver = GoogleChrome.getDriver();
        carrinhoPage = new CarrinhoPage(driver);
    }
    @Given("que os produtos são listados")
    public void que_os_produtos_sao_listados() {
        carrinhoPage.acessarTelaPrincipal();
    }
    @When("eu clico no botão Add to cart")
    public void euClicoNoBotãoAddToCart() {
        carrinhoPage.adicionarProduto();
    }
    @Then("o produto é adicionado ao carrinho")
    public void oProdutoÉAdicionadoAoCarrinho() {
        carrinhoPage.verificarCarrinho();
    }
    @Given("que há produtos adicionados ao carrinho")
    public void queHáProdutosAdicionadosAoCarrinho() {
        carrinhoPage.adicionarProduto();
        boolean isCarrinhoVazio = carrinhoPage.verificarCarrinho();
        assertFalse(isCarrinhoVazio);
    }
    @When("eu clico no botão Remove em um desses produtos")
    public void euClicoNoBotãoRemoveEmUmDessesProdutos() {
        carrinhoPage.removerProdutoNaTelaPrincipal();
    }
    @Then("o o produto é removido do carrinho")
    public void oOProdutoÉRemovidoDoCarrinho() {
        boolean isCarrinhoVazio = carrinhoPage.verificarCarrinho();
        assertTrue(isCarrinhoVazio);
    }
    @Given("que eu acesso o carrinho")
    public void queEuAcessoOCarrinho() {
        carrinhoPage.acessarCarrinho();
    }

    @And("eu clico no botão Check out")
    public void euClicoNoBotãoCheckOut() {
        carrinhoPage.realizarCheckout();
    }

    @And("preencho as informações necessárias para entrega do pedido")
    public void preenchoAsInformaçõesNecessáriasParaEntregaDoPedido() {
        carrinhoPage.preencherDadosPedido("Taís","Nayara","69055737");
        carrinhoPage.continuarPedido();
    }

    @And("as informações do pedido são exibidas")
    public void asInformaçõesDoPedidoSãoExibidas() {
        carrinhoPage.exibirInformacoesPedido();
    }

    @When("eu clico no botão Finish")
    public void euClicoNoBotãoFinish() {
        carrinhoPage.finalizarPedido();
    }

    @Then("o pedido é realizado com sucesso")
    public void oPedidoÉRealizadoComSucesso() {
        boolean isCarrinhoVazio = carrinhoPage.verificarCarrinho();
        assertTrue(isCarrinhoVazio);
        carrinhoPage.acessarTelaPrincipal();
    }

    @And("a mensagem de confirmação é exibida")
    public void aMensagemDeConfirmaçãoÉExibida() {
        carrinhoPage.exibirMensagemConfirmacao();
    }

    @And("preencho as informações necessárias para entrega do pedido sem informar o campo first name")
    public void preenchoAsInformaçõesNecessáriasParaEntregaDoPedidoSemInformarOCampoFirstName() {
        carrinhoPage.preencherDadosPedido("","Nayara","69055737");
    }

    @When("eu clico no botão Continue")
    public void euClicoNoBotãoContinue() {
        carrinhoPage.continuarPedido();
    }

    @Then("uma mensagem de erro é exibida indicando que o campo first name é obrigatório")
    public void umaMensagemDeErroÉExibidaIndicandoQueOCampoFirstNameÉObrigatório() {
        carrinhoPage.mostrarMensagem("Error: First Name is required");
    }

    @And("preencho as informações necessárias para entrega do pedido sem informar o campo last name")
    public void preenchoAsInformaçõesNecessáriasParaEntregaDoPedidoSemInformarOCampoLastName() {
        carrinhoPage.preencherDadosPedido("Taís","","69055737");
    }

    @Then("uma mensagem de erro é exibida indicando que o campo last name é obrigatório")
    public void umaMensagemDeErroÉExibidaIndicandoQueOCampoLastNameÉObrigatório() {
        carrinhoPage.mostrarMensagem("Error: Last Name is required");
    }

    @And("preencho as informações necessárias para entrega do pedido sem informar o campo postal code")
    public void preenchoAsInformaçõesNecessáriasParaEntregaDoPedidoSemInformarOCampoZipPostalCode() {
        carrinhoPage.preencherDadosPedido("Taís","Nayara","");
    }

    @Then("uma mensagem de erro é exibida indicando que o campo postal code é obrigatório")
    public void umaMensagemDeErroÉExibidaIndicandoQueOCampoZipPostalCodeÉObrigatório() {
        carrinhoPage.mostrarMensagem("Error: Postal Code is required");
    }

    @After
    public void finalize() {
        // Fecha o navegador após cada cenário
        if (driver != null) {
            GoogleChrome.quitDriver();
        }
    }

}
