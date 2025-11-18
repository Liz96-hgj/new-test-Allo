package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPaymentPage extends BasePage {

    public DeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String DELIVERY_AND_PAYMENT = "//a[contains(@class, 'mh-button') and contains(normalize-space(.), 'Доставка і оплата')]";
    private final String HOW_TO_ORDER = "//*[@class='sp-tablinks active']";

    public WebElement deliveryAndPayment() {
        return visibilityOfElementByXpath(DELIVERY_AND_PAYMENT);
    }

    public WebElement howToOrder() {
        return visibilityOfElementByXpath(HOW_TO_ORDER);
    }

}
