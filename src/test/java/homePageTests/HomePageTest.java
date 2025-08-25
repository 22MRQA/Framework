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

    //    Завдання 1
    @Test
    public void checkCatalogButtonDisplay() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement catalogButtonLocator = driver.findElement(By.xpath("//div[@class='mh-catalog-btn']"));


        Assert.assertTrue(catalogButtonLocator.isDisplayed());


    }

    //    Завдання 2

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


}