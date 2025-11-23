package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardPage extends BasePage {

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }
    private final String PRODUCT_NAME1 = "//h1[@class='p-view__header-title']";
    private final String BUY_BUTTON = "(//button[@title='Купити'])[2]";
    private final String PRODUCT_NAME2 = "//h1[@class='p-view__header-title']";

    @FindBy(xpath = "(//button[@title='Купити'])[2]")
    private WebElement buyButton;

    public WebElement buyButton() {
        return visibilityOfElementByXpath(BUY_BUTTON);
    }

    public WebElement productName1() {
        return visibilityOfElementByXpath(PRODUCT_NAME1);
    }

    public WebElement productName2() {
        return visibilityOfElementByXpath(PRODUCT_NAME2);
    }

    public void clickBuyButton() {           //метод для пошуку і скролу кнопки
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buyButton()));
        scrollToElement(button);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();
    }

}
