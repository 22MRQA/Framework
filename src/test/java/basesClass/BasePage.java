package basesClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// будемо зберігати методи які будеть взаємодіяти з нашою пейджею (знаходити елементи, клікати, вводити текст, виятгувати текст)
// всі методі будуть абстрактні, ніякі значення туди передаватися не будуть.
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement visibilityOfElementByXpath(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clikElement(WebElement element) {
        element.click();
    }

    public boolean isElementDisplayed(WebElement element) {
      return element.isDisplayed();
    }

}
