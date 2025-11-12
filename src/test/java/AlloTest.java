

import basesClass.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import java.time.Duration;

public class AlloTest extends TestInit {

    public String alloUrl = "https://allo.ua";

    @Test
    public void alloLogoTest() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

    }

    @Test
    public void checkSearchFieldAndSearchResults() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchInput().isDisplayed());

        homePage.searchInput().sendKeys("Фен");
        homePage.searchButton().click();

        String expectedWord = "фен";
        Assert.assertTrue(searchResultPage.firstProduct().getText().contains(expectedWord));

    }

    @Test
    public void checkAirPods3SearchAndCompareName() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        String producnName = "AirPods 3";
        homePage.searchInput().sendKeys(producnName);
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstProduct3().getText().contains(producnName));
        searchResultPage.firstProduct3().click();


        Assert.assertTrue(searchResultPage.productTitle().getText().contains(producnName));

    }

    @Test
    public void checkBuyersDeliveryAndPayment() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();


        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());
        Assert.assertTrue(homePage.deliveryAndPayment().isDisplayed());
        homePage.deliveryAndPayment().click();

        String deliverySectionTitle = "Доставка і оплата";
        Assert.assertTrue(homePage.deliveryAndPayment().getText().contains(deliverySectionTitle));

        Assert.assertTrue(searchResultPage.howToOrder().isDisplayed());

        String howToOrderTitle = "Як оформити замовлення";
        Assert.assertTrue(searchResultPage.howToOrder().getText().contains(howToOrderTitle));


    }

}