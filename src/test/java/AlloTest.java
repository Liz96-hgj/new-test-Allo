

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
    public void AlloLogoTest()  {

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

        Assert.assertTrue(searchResultPage.firstProduct().getText().toLowerCase().contains("фен"));

    }

    @Test
    public void checkAirPods3SearchAndCompareName() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());


        homePage.searchInput().sendKeys("AirPods 3");
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstProduct3().getText().contains("AirPods 3"));
        searchResultPage.firstProduct3().click();


        Assert.assertTrue(searchResultPage.productTitle().getText().contains("AirPods 3"));


    }

    @Test
    public void checkBuyersDeliveryAndPayment() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();


        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());

        Assert.assertTrue(homePage.deliveryAndPayment().isDisplayed());
        homePage.deliveryAndPayment().click();

        Assert.assertTrue(homePage.deliveryAndPayment().getText().contains("Доставка і оплата"));

        Assert.assertTrue(searchResultPage.howToOrder().isDisplayed());

        Assert.assertTrue(searchResultPage.howToOrder().getText().contains("Як оформити замовлення?"));


    }
}
