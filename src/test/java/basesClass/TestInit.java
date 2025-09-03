package basesClass;

// Це головний батьківський клас, в якому будемо виконувать створеня інеціалізацію нашего веб драйвера,\
//який буде взаємодіїти з нашим браузером по типу користувача

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    public WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void openUrl(String url){
        driver.get(url);
    }

}
