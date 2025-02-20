package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoElements {

    @FindBy(xpath = "//*[@data-test='title']")
    public static WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public static WebElement addToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public static WebElement removeFromCartButton;

    @FindBy(xpath = "//*[@data-test='shopping-cart-badge']")
    public WebElement cartButton;

    @FindBy(id = "checkout")
    public static WebElement checkoutButton;

    @FindBy(id = "first-name")
    public static WebElement firstNameField;

    @FindBy(id = "last-name")
    public static WebElement lastNameField;

    @FindBy(id = "postal-code")
    public static WebElement postalCodeField;

    @FindBy(id = "continue")
    public static WebElement continueButton;

    @FindBy(id = "finish")
    public static WebElement finishButton;

    @FindBy(xpath = "//*[@data-test='cart-quantity-label']")
    public static WebElement labelQTY;

    @FindBy(xpath = "//*[@data-test='cart-desc-label']")
    public static WebElement labelDescription;

    @FindBy(xpath = "//*[@data-test='inventory-item-name']")
    public static WebElement productName;

    @FindBy(xpath = "//*[@data-test='inventory-item-price']")
    public static WebElement productPrice;

    @FindBy(xpath = "//*[@data-test='payment-info-label']")
    public static WebElement labelPaymentInfo;

    @FindBy(xpath = "//*[@data-test='payment-info-value']")
    public static WebElement labelPaymentInfoValue;

    @FindBy(xpath = "//*[@data-test='shipping-info-label']")
    public static WebElement labelShippingInfo;

    @FindBy(xpath = "//*[@data-test='shipping-info-value']")
    public static WebElement labelShippingInfoValue;

    @FindBy(xpath = "//*[@data-test='total-info-label']")
    public static WebElement labelPriceTotalInfo;

    @FindBy(xpath = "//*[@data-test='subtotal-label']")
    public static WebElement labelSubTotal;

    @FindBy(xpath = "//*[@data-test='tax-label']")
    public static WebElement labelTax;

    @FindBy(xpath = "//*[@data-test='total-label']")
    public static WebElement labelTotal;

    @FindBy(xpath = "//*[@data-test='complete-header']")
    public static WebElement mainMessage;

    @FindBy(xpath = "//*[@data-test='complete-text']")
    public static WebElement secondaryMessage;

    @FindBy(xpath = "//*[@data-test='error']")
    public WebElement errorMessageContainer;

}
