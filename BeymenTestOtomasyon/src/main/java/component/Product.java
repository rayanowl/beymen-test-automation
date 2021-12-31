package component;

import config.SeleniumConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {

    WebDriver driver;
    public WebDriverWait wait;


    public @FindBy(how = How.ID, using = "addBasket")
    WebElement addBasket;
    public @FindBy(how = How.XPATH, using = "//*[@id=\"priceNew\"]")
    WebElement showCasePrice;
    public @FindBy(how = How.XPATH, using = "//button[@class='m-notification__button btn']")
    WebElement goToBasket;
    public @FindBy(how = How.XPATH, using = "/html/body/div[5]/div/div[1]/div[3]/div/div/button")
    WebElement showMoreContentButton;
    public @FindBy(how = How.XPATH, using = "/html/body")
    WebElement html;


    public Product() {
        this.wait = SeleniumConfig.wait;
        this.driver = SeleniumConfig.driver;
        PageFactory.initElements(driver, this);
    }
}
