package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_PROUDCT = "(//a[contains(@class, 'product-card__title') and contains(text(), 'Фен')])[1]";
    private final String FIRST_PRODUCT3 = "(//a[@class='product-card__title' and contains(text(), 'AirPods 3')])[1]";
    private final String PRODUCT_TITLE = "//h1[@class='p-view__header-title']";
    private final String VIEW_MODEL_BUTTON = "//button[@class='view-mode__button' and @title='Таблиця']";
    private final String NAMES_SEARCHED_PRODUCTS = "//div[@class='product-card__content']/a[@class='product-card__title']";
    private final String COMMENTS_PRODUCT = "(//span[@class='review-button__text review-button__text--count'])[1]";
    private final String PROMOTIONAL_OFFER_BUTTON = "//a[@class='f-check' and contains(text(), 'Акційна пропозиція')]";
    private final String PHONE_CASES_BUTTON = "//a[@class='f-radio' and contains(text(), 'Чохли для смартфонів')]";
    private final String FIRST_PRODUCT_NAME = "//a[@title='Чохол Apple Clear Case with MagSafe MA6A4ZM/A для iPhone 16']";
    private final String SECOND_PRODUCT_NAME = "//a[@title='Чохол MAKE Frame Magnet (MCFM-AI16PM) для Apple iPhone 16 Pro Max']";

    public WebElement firstProduct() {
        return visibilityOfElementByXpath(FIRST_PROUDCT);
    }

    public WebElement firstProduct3() {
        return visibilityOfElementByXpath(FIRST_PRODUCT3);
    }

    public WebElement productTitle() {
        return visibilityOfElementByXpath(PRODUCT_TITLE);

    }

    public WebElement promotionalOfferButton() {
        return visibilityOfElementByXpath(PROMOTIONAL_OFFER_BUTTON);
    }

    public WebElement phoneCasesButton() {
        return visibilityOfElementByXpath(PHONE_CASES_BUTTON);
    }

    public WebElement firstProductName() {
        return visibilityOfElementByXpath(FIRST_PRODUCT_NAME);
    }

    public WebElement secondProductName() {
        return visibilityOfElementByXpath(SECOND_PRODUCT_NAME);
    }

    public WebElement viewModeButton() {
        return visibilityOfElementByXpath(VIEW_MODEL_BUTTON);
    }

    public List<WebElement> namesSearchedProducts() {
        return visibilityOfElementsLocatorByXpath(NAMES_SEARCHED_PRODUCTS);
    }
    public List<WebElement> commentsSearchedProducts() {
        return visibilityOfElementsLocatorByXpath(COMMENTS_PRODUCT);
    }

    public void viewModelButtonDisplayed() {
        viewModeButton().isDisplayed();

    }

}
