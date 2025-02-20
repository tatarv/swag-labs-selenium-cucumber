package pages;

import elements.CarrinhoElements;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CarrinhoPage {
    private WebDriver driver;
    private CarrinhoElements carrinhoElements;

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        carrinhoElements = new CarrinhoElements();
        PageFactory.initElements(driver, carrinhoElements);
    }
    public void acessarTelaPrincipal(){
        carrinhoElements.pageTitle.isDisplayed();
    }
    public void adicionarProduto(){
        carrinhoElements.addToCartButton.click();
    }
    public boolean verificarCarrinho(){
        try {
            // Verifica se o elemento está visível
            if (carrinhoElements.cartButton.isDisplayed()) {
                System.out.println("Elemento está visível.");
                return false; // Carrinho não está vazio
            }
        } catch (NoSuchElementException e) {
            // Se o elemento não for encontrado
            System.out.println("Elemento não encontrado. Consideramos que o carrinho está vazio.");
        }
        return true;
    }
    public void removerProdutoNaTelaPrincipal(){
        carrinhoElements.removeFromCartButton.click();
    }
    public void acessarCarrinho(){
        carrinhoElements.cartButton.click();
    }
    public void realizarCheckout(){
        carrinhoElements.checkoutButton.click();
    }
    public void preencherDadosPedido(String firstName,String lastName,String postalCode){
        carrinhoElements.firstNameField.sendKeys(firstName);
        carrinhoElements.lastNameField.sendKeys(lastName);
        carrinhoElements.postalCodeField.sendKeys(postalCode);
    }
    public void continuarPedido(){
        carrinhoElements.continueButton.click();
    }
    public void exibirInformacoesPedido(){
        carrinhoElements.labelQTY.isDisplayed();
        carrinhoElements.labelDescription.isDisplayed();
        carrinhoElements.productName.isDisplayed();

        String nomeProduto = carrinhoElements.productName.getText().trim();
        System.out.println(nomeProduto);

        carrinhoElements.productPrice.isDisplayed();

        String precoProduto = carrinhoElements.productPrice.getText().trim();
        System.out.println(precoProduto);

        carrinhoElements.labelPaymentInfo.isDisplayed();
        carrinhoElements.labelPaymentInfoValue.isDisplayed();

        String informacaoPagamento = carrinhoElements.labelPaymentInfoValue.getText().trim();
        System.out.println(informacaoPagamento);

        carrinhoElements.labelShippingInfo.isDisplayed();

        carrinhoElements.labelShippingInfoValue.isDisplayed();
        String informacoesEnvio = carrinhoElements.labelShippingInfoValue.getText().trim();
        System.out.println(informacoesEnvio);

        carrinhoElements.labelPriceTotalInfo.isDisplayed();

        carrinhoElements.labelSubTotal.isDisplayed();
        String subTotal = carrinhoElements.labelSubTotal.getText().trim();
        System.out.println(subTotal);

        carrinhoElements.labelTax.isDisplayed();
        String tax = carrinhoElements.labelTax.getText().trim();
        System.out.println(tax);

        carrinhoElements.labelTotal.isDisplayed();
        String total = carrinhoElements.labelTotal.getText().trim();
        System.out.println(total);
    }
    public void finalizarPedido(){
        carrinhoElements.finishButton.click();
    }
    public void exibirMensagemConfirmacao (){
        carrinhoElements.mainMessage.isDisplayed();
        carrinhoElements.secondaryMessage.isDisplayed();

        String mainMessage = carrinhoElements.mainMessage.getText().trim();
        String secondaryMessage = carrinhoElements.secondaryMessage.getText().trim();
        System.out.println(mainMessage);
        System.out.println(secondaryMessage);
    }

    public void mostrarMensagem(String mensagem) {
        String mensagemAtual = carrinhoElements.errorMessageContainer.getText().trim();
        System.out.printf(mensagemAtual);
        mensagemAtual.contains(mensagem);
    }
}
