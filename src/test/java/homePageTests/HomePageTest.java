package homePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
    }

    @Test
    public void checkCatalogButton() throws InterruptedException {

        sleep(2000);

        WebElement catalogLocatorButton = driver.findElement(By.xpath("//div[@class='mh-catalog-btn']"));

        Assert.assertTrue(catalogLocatorButton.isDisplayed());

    }


    @Test
    public void checkCatalogTovaruDlyaGamerButton() throws InterruptedException {

        WebElement catalogLocatorButton = driver.findElement(By.xpath("//div[@class='mh-catalog-btn']"));
        catalogLocatorButton.click();

        sleep(5000);

        WebElement catalogGamerButton = driver.findElement(By.xpath("(//a[@class='mm__a'])[7]"));

        Assert.assertTrue(catalogGamerButton.isDisplayed());

        catalogGamerButton.click();

    }


    @Test
    public void verifyDostavkaAndOplataPageViaBuyersMenu() throws InterruptedException {

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

    @AfterMethod

    public void close() {
        driver.quit();
    }

}