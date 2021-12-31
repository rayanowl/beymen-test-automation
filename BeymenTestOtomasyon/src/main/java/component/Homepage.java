package component;

import config.SeleniumConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

    WebDriver driver;
    public WebDriverWait wait;


    public @FindBy(how = How.XPATH, using = "/html/body/header/div/div/div[3]/div/a[@class='o-header__userInfo--item bwi-account-o -customer']/span[@class='o-header__userInfo--text']")
    WebElement hesabim_Button;
    public  @FindBy(how = How.XPATH, using = "/html/body/header/div/div/div[3]/div/a[@class='o-header__userInfo--item bwi-favorite-o -favorite']")
    WebElement favorilerim_Button;
    public  @FindBy(how = How.XPATH, using = "/html/body/header/div/div/div[3]/div/a[@class='o-header__userInfo--item bwi-cart-o -cart']")
    WebElement sepetim_Button;
    public  @FindBy(how = How.XPATH,using = "/html/body/header/div/div/div[2]/div/div/div/input[@class='default-input o-header__search--input']")
    WebElement search_Button;




    public Homepage(){
        this.wait = SeleniumConfig.wait;
        this.driver = SeleniumConfig.driver;
        PageFactory.initElements(driver,this);
    }

}
