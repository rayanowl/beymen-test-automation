package component;

import config.SeleniumConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basket {

    WebDriver driver;
    public WebDriverWait wait;

    public @FindBy(how = How.XPATH,using = "//span[@class='m-productPrice__salePrice']")
    WebElement basketPrice;
    public @FindBy(how = How.XPATH,using = "//span[@class='m-productPrice__salePrice']")
    WebElement quantity;



    public Basket(){
        this.wait = SeleniumConfig.wait;
        this.driver = SeleniumConfig.driver;
        PageFactory.initElements(driver,this);
    }
}
