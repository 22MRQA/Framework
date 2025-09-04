package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsForGamersPage extends BasePage {

    public ProductsForGamersPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_ELEMENT_SECTION_GAME_CONSOLES = "(//a[@class='head-nav-a'])[1]";

    public WebElement firstGameCosolesButton() {
        return visibilityOfElementByXpath(FIRST_ELEMENT_SECTION_GAME_CONSOLES);
    }

    public String getNameFirstGameCosolesButton() {
        return firstGameCosolesButton().getText();
    }

    public boolean firstGameCosolesButtonDisplyaed(){
        return isElementDisplayed(firstGameCosolesButton());
    }
}
