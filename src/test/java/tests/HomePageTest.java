package tests;

import basesClass.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsForGamersPage;

import static java.lang.Thread.sleep;

public class HomePageTest extends TestInit {

    public String alloUrl = "https://allo.ua/";

    @Test
    public void checkCatalogButton() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.catalogButton().isDisplayed());

    }

    @Test
    public void checkCatalogTovaruDlyaGamerButton() {
        HomePage homePage = new HomePage(driver);
        ProductsForGamersPage productsForGamersPage = new ProductsForGamersPage(driver);

        openUrl(alloUrl);

        homePage.clickCatalogButton();
        Assert.assertTrue(homePage.catalogGamerButtonDisplyaed());

        homePage.clickCatalogGamerButton();
        Assert.assertTrue(productsForGamersPage.firstGameCosolesButtonDisplyaed());

        String nameFirstGameConsolesButton = productsForGamersPage.getNameFirstGameCosolesButton();
        Assert.assertTrue(nameFirstGameConsolesButton.contains("Ігрові консолі"));

        // Додати 1 перевірку на сторінці яка відкрилася очікуваний елемент унікальний тільки для цієї сторінки відображаєтся на екрані
        // Додати 2-гу перевірку що 1 із елементів на сторінці містить очікуваний текст

    }

    @Test
    public void verifyDostavkaAndOplataPageViaBuyersMenu() throws InterruptedException {
        openUrl(alloUrl);
        sleep(2000);

        WebElement siteLogo = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(siteLogo.isDisplayed());

        sleep(2000);

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        searchInput.sendKeys("AirPods 3");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();

        sleep(5000);

        WebElement productCard = driver.findElement(By.xpath("//div[@data-product-id='14092905']"));
        String productCardText = productCard.getText();

        Assert.assertTrue(productCardText.contains("AirPods 3"), "Назва не містить Airpods 3");

        WebElement firstProductTitleLink = driver.findElement(By.xpath("(//a[@class='product-card__title'])[1]"));
        String expectedProductTitle = firstProductTitleLink.getText();

        firstProductTitleLink.click();

        sleep(5000);

        WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualProductTitle = productPageTitle.getText();

        Assert.assertEquals(actualProductTitle, expectedProductTitle);

    }

    @Test
    public void checkHeaderItems() throws InterruptedException {
        openUrl(alloUrl);
        WebElement buyerMenuButton = driver.findElement(By.xpath("//div[@class='mh-button__wrap']"));
        Assert.assertTrue(buyerMenuButton.isDisplayed());

        buyerMenuButton.click();
        sleep(2000);

        WebElement buyerDropDownMenu = driver.findElement(By.xpath("//div[@class='mh-button__dropdown']"));
        Assert.assertTrue(buyerDropDownMenu.isDisplayed());

        WebElement deliveryAndPaymentButton = driver.findElement(By.xpath("(//a[@class='mh-button'])[5]"));
        Assert.assertTrue(deliveryAndPaymentButton.isDisplayed());

        deliveryAndPaymentButton.click();

        WebElement deliveryAndPaymentTitle = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));
        String pageTitleText = deliveryAndPaymentTitle.getText();
        Assert.assertTrue(pageTitleText.contains("Доставка і оплата"));

        WebElement orderProcessSubtitle = driver.findElement(By.xpath("(//h3[@class='sub-block-header'])[1]"));
        Assert.assertTrue(orderProcessSubtitle.isDisplayed());

        String orderProcessText = orderProcessSubtitle.getText();
        Assert.assertTrue(orderProcessText.contains("Як оформити замовлення?"));

        System.out.println(orderProcessText);

    }

    @AfterMethod

    public void close() {
        driver.quit();
    }


}