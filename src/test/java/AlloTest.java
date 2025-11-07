

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AlloTest {

    @Test
    public void AlloLogoTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");
        sleep(3000);
        WebElement alloButtonLocator = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(alloButtonLocator.isDisplayed());
        driver.quit();
    }

    @Test
    public void checkSearchFieldAndSearchResults() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchInput.isDisplayed(), "Поле пошуку не відображається !");
        searchInput.sendKeys("Фен");
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
        searchButton.click();
        sleep(2000);
        WebElement firstProduct = driver.findElement(By.xpath("//a[contains(@class, 'product-card__title')][1]"));
        String productText = firstProduct.getText();
        Assert.assertTrue(productText.toLowerCase().contains("фен"));
        driver.quit();
    }

    @Test
    public void checkAirPods3SearchAndCompareName() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");
        sleep(3000);
        WebElement alloLogo = driver.findElement(By.xpath("//*[@class='v-logo']"));
        Assert.assertTrue(alloLogo.isDisplayed());
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='search-form__input']"));
        searchInput.sendKeys("AirPods 3");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and @class='search-form__submit-button']"));
        searchButton.click();
        sleep(3000);
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='product-card__title' and contains(text(), 'AirPods 3')])[1]"));
        String productName = firstProduct.getText();
        Assert.assertTrue(productName.contains("AirPods 3"));
        firstProduct.click();
        sleep(3000);
        WebElement productTitle = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String productPageName = productTitle.getText();
        Assert.assertEquals(productPageName, productName, "Назва товару на сторінці не збігається!");
        driver.quit();
    }

    @Test
    public void checkBuyersDeliveryAndPayment() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");
        WebElement buyersButton = driver.findElement(By.xpath("//a[contains(text(),'Покупцям')]"));
        Assert.assertTrue(buyersButton.isDisplayed(), "Кнопка 'Покупцям' не відображається!");
        buyersButton.click();
        sleep(1000);
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@class='mh-button__wrap active']"));
        Assert.assertTrue(dropDownMenu.isDisplayed(), "Dropdown меню не відкрилося!");
        WebElement deliveryAndPayment = driver.findElement(By.xpath("//a[contains(text(),'Доставка і оплата')]"));
        Assert.assertTrue(deliveryAndPayment.isDisplayed(), "'Доставка і оплата' не відображається!");
        deliveryAndPayment.click();
        sleep(2000);
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Доставка і оплата"), "Тайтл сторінки не містить 'Доставка і оплата'");
        WebElement howToOrder = driver.findElement(By.xpath("//*[@class='sp-tablinks active']"));
        Assert.assertTrue(howToOrder.isDisplayed(), "'Як оформити замовлення?' не відображається!");
        Assert.assertEquals(howToOrder.getText(), "Як оформити замовлення?", "Текст елемента не збігається!");
        driver.quit();
    }
}
