package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsForGamersPage extends BasePage {

    public ProductsForGamersPage(WebDriver driver) {
        super(driver);
    }

    private final String EXPECTED_FIRST_ITEM = "(//a[@class='head-nav-a'])[1]";

    public WebElement expectedFirstItem(){
        return visibilityOfElementByXpath(EXPECTED_FIRST_ITEM);
    }


    public String getNameExpectedFirstItem (){
        return expectedFirstItem().getText();
    }


}
