package pages;

import basesClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String CATALOG_BUTTON = "//div[@class='mh-catalog-btn']";
    private final String SEARCH_INPUT = "//input[@id='search-form__input']";
    private final String SEARCH_BUTTON ="//button[contains(@class, 'search-form__submit')]";
    private final String BUYERS_BUTTON = "//a[contains(text(),'Покупцям')]";
    private final String DROP_DOWN_MENU = "//a[contains(text(),'Покупцям')]";

    public WebElement alloLogo() {
        return visibilityOfElementByXpath(ALLO_LOGO);
    }

    public WebElement catalogButton() {
        return visibilityOfElementByXpath(CATALOG_BUTTON);
    }

    public WebElement searchInput() {
        return visibilityOfElementByXpath(SEARCH_INPUT);
    }

    public WebElement searchButton() {
        return visibilityOfElementByXpath(SEARCH_BUTTON);
    }

    public WebElement buyersButton() {
        return visibilityOfElementByXpath(BUYERS_BUTTON);
    }

    public WebElement dropDownMenu() {
        return visibilityOfElementByXpath(DROP_DOWN_MENU);
    }

}
