package tests;

import basesClass.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryAndPaymentPage;
import pages.HomePage;
import pages.SearchResultPage;

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
        String expectedWord = "фен";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchInput().isDisplayed());

        homePage.searchInput().sendKeys(expectedWord);
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstProduct().getText().contains(expectedWord));

    }

    @Test
    public void checkAirPods3SearchAndCompareName() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String productName = "AirPods 3";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchInput().sendKeys(productName);
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstProduct3().getText().contains(productName));
        searchResultPage.firstProduct3().click();


        Assert.assertTrue(searchResultPage.productTitle().getText().contains(productName));

    }

    @Test
    public void checkBuyersDeliveryAndPayment() {

        HomePage homePage = new HomePage(driver);
        DeliveryAndPaymentPage deliveryAndPaymentPage = new DeliveryAndPaymentPage(driver);
        String deliverySectionTitle = "Доставка і оплата";
        String howToOrderTitle = "Як оформити замовлення";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyersButton().isDisplayed());
        homePage.buyersButton().click();


        Assert.assertTrue(homePage.dropDownMenu().isDisplayed());
        Assert.assertTrue(deliveryAndPaymentPage.deliveryAndPayment().isDisplayed());
        deliveryAndPaymentPage.deliveryAndPayment().click();

        Assert.assertTrue(deliveryAndPaymentPage.deliveryAndPayment().getText().contains(deliverySectionTitle));

        Assert.assertTrue(deliveryAndPaymentPage.howToOrder().isDisplayed());

        Assert.assertTrue(deliveryAndPaymentPage.howToOrder().getText().contains(howToOrderTitle));

    }

}
