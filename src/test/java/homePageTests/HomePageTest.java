package homePageTests;


//import com.beust.ah.A;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTest {


    @Test
    public void checkCatalogButtonDisplay() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='mh-catalog-btn']"));


        Assert.assertTrue(catalogButtonLocator.isDisplayed());


    }

    @Test
    public void checkCatalogButtonOpen() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='mh-catalog-btn']"));

        catalogButtonLocator.click();

        sleep(5000);


        WebElement catalogButtonGamer = driver.findElement(By.xpath("//a[contains(., 'Побутова техніка')]"));

        Assert.assertTrue(catalogButtonGamer.isDisplayed());

        catalogButtonGamer.click();

        driver.quit();


    }

//    3 Завдання

    @Test
    public void checkLogoAllo() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement logoAlloDisplay = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(logoAlloDisplay.isDisplayed());

//        driver.quit();


        sleep(2000);

        WebElement searchMenu = driver.findElement(By.xpath("//input[@id='search-form__input']"));

        searchMenu.sendKeys("AirPods 3");

        WebElement buttonLupa = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));

        buttonLupa.click();

        sleep(5000);

        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-product-id='14092905']"));

        String actualProduct = firstProduct.getText();

        Assert.assertTrue(actualProduct.contains("AirPods 3"), "Назва не містить Airpods 3");

        WebElement fullName = driver.findElement(By.xpath("(//a[@class='product-card__title'])[1]"));

        String name = fullName.getText();

//        System.out.println(name);

        fullName.click();

        sleep(5000);

        WebElement checkName = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));

        String checkEqualsName = checkName.getText();

        Assert.assertEquals(checkEqualsName, name);

        driver.quit();

    }

//    4 Завдання

}