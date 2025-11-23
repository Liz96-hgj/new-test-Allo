package tests;

import basesClass.TestInit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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

    @Test
    public void checkResultSearchField() {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        String samsungTV = "Телевізор Samsung";
        int expectedSizeProducts = 60;

        openUrl(alloUrl);

        homePage.enterValuesInSearchField(samsungTV);
        homePage.clickSearchButton();

        searchResultPage.viewModelButtonDisplayed();
        int sizeProducts = searchResultPage.namesSearchedProducts().size();

        Assert.assertEquals(sizeProducts, expectedSizeProducts);

        for (WebElement element : searchResultPage.namesSearchedProducts()) {
            Assert.assertTrue(element.getText().contains(samsungTV));
        }

    }

    @Test
    public void checkingProductComments () {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        String samsungTV = "Телевізор Samsung";
        int expectedSizeProducts = 60;

        openUrl(alloUrl);

        homePage.enterValuesInSearchField(samsungTV);
        homePage.clickSearchButton();

        searchResultPage.viewModelButtonDisplayed();
        int sizeProducts = searchResultPage.namesSearchedProducts().size();

        Assert.assertEquals(sizeProducts, expectedSizeProducts);

        for(WebElement element : searchResultPage.commentsSearchedProducts()) {
           String numberComments = element.getText();
           int number = Integer.parseInt(numberComments);
           if (number > 27) {
               System.out.println(number);
           }
       }

    }

    @Test
    public void orderingProducts ()  {

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        ProductCardPage productCardPage = new ProductCardPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String expectedWord1 = "Apple ";
        String expectedWord2 = "Чохол Apple Clear Case with MagSafe MA6A4ZM/A для iPhone 16";
        String expectedWord3 = "Чохол MAKE Frame Magnet (MCFM-AI16PM) для Apple iPhone 16 Pro Max";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchInput().isDisplayed());

        homePage.searchInput().sendKeys(expectedWord1);
        homePage.searchButton().click();

        searchResultPage.phoneCasesButton().click();

        Assert.assertTrue(searchResultPage.firstProductName().getText().contains(expectedWord2));
        searchResultPage.firstProductName().click();

        Assert.assertTrue(productCardPage.productName1().getText().contains(expectedWord2));

        productCardPage.clickBuyButton();

        driver.navigate().back();

        Assert.assertTrue(searchResultPage.secondProductName().getText().contains(expectedWord3));
        searchResultPage.secondProductName().click();

        Assert.assertTrue(productCardPage.productName2().getText().contains(expectedWord3));

        productCardPage.clickBuyButton();

        driver.navigate().back();

        Assert.assertTrue(homePage.alloLogo().isDisplayed());
        homePage.alloLogo().click();

        Assert.assertTrue(shoppingCartPage.basketButton().isDisplayed());
        shoppingCartPage.basketButton().click();

    }

}
