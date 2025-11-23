package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    private final String PLACING_AN_ORDER = "//button[@class='order-now']";
    private final String BASKET_BUTTON = "//button[@aria-label='Кошик']";

    public WebElement placingAnOrder() {
        return visibilityOfElementByXpath(PLACING_AN_ORDER);
    }

    public WebElement basketButton() {
        return visibilityOfElementByXpath(BASKET_BUTTON);
    }

}
