package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_PROUDCT = "(//a[contains(@class, 'product-card__title') and contains(text(), 'Фен')])[1]";
    private final String FIRST_PRODUCT3 = "(//a[@class='product-card__title' and contains(text(), 'AirPods 3')])[1]";
    private final String PRODUCT_TITLE = "//h1[@class='p-view__header-title']";

    public WebElement firstProduct() {
        return visibilityOfElementByXpath(FIRST_PROUDCT);
    }

    public WebElement firstProduct3() {
        return visibilityOfElementByXpath(FIRST_PRODUCT3);
    }

    public WebElement productTitle() {
        return visibilityOfElementByXpath(PRODUCT_TITLE);
    }

}
