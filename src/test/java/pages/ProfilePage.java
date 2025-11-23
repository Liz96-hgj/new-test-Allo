package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private final String PROFILE_TAB = "//button[@class='mh-button mh-button--open']";

    public WebElement profileTab() {
        return visibilityOfElementByXpath(PROFILE_TAB);
    }
}
