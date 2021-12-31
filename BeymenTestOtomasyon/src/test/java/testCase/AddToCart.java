package testCase;

import component.Basket;
import component.Homepage;
import component.Product;
import config.SeleniumConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testlogger.TestResultLogger;

import java.util.List;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class AddToCart {



    Basket basket = new Basket();
    static String firstPrice;

    @BeforeAll
    public static void beforeAll() {
        SeleniumConfig.initializeChromeDriver();
        SeleniumConfig.driver.get("https://www.beymen.com/");
    }

    @Test
    @Order(1)
    public void homePageCheck() {
        Homepage homepage = new Homepage();
        homepage.wait.until(ExpectedConditions.visibilityOf(homepage.hesabim_Button));
        homepage.wait.until(ExpectedConditions.visibilityOf(homepage.favorilerim_Button));
        homepage.wait.until(ExpectedConditions.visibilityOf(homepage.sepetim_Button));
        homepage.wait.until(ExpectedConditions.elementToBeClickable(homepage.hesabim_Button));
        homepage.wait.until(ExpectedConditions.elementToBeClickable(homepage.favorilerim_Button));
        homepage.wait.until(ExpectedConditions.elementToBeClickable(homepage.sepetim_Button));
    }

    @Test
    @Order(2)
    public void searchPantolon() {
        Homepage homepage = new Homepage();
        homepage.search_Button.sendKeys("pantolon");
        homepage.search_Button.sendKeys(Keys.ENTER);
    }

    @Test
    @Order(3)
    public void scrollPageDown () throws InterruptedException {
        Product product = new Product();
        Thread.sleep(100);
        product.html.sendKeys(Keys.PAGE_DOWN);

    }

    @Test
    @Order(4)
    public void showMoreContent() throws InterruptedException {
        Product product = new Product();
        Thread.sleep(100);
        product.showMoreContentButton.click();
    }

    @Test
    @Order(5)
    public void selectRandomProduct() throws InterruptedException {
        List<WebElement> listingsProduct = SeleniumConfig.driver.findElements(By.xpath("/html/body/div[5]/div/div[1]/div[2]/div/div/div/div[@class='m-productCard__photo']"));
        Random r = new Random();
        int randomValue = r.nextInt(listingsProduct.size() - 1);
        Thread.sleep(100);
        listingsProduct.get(randomValue).click();
    }

    @Test
    @Order(6)
    public void addTocart() {
        List<WebElement> listingsSize = SeleniumConfig.driver.findElements(By.xpath("//*[@id=\"sizes\"]/div/span[@class='m-variation__item']"));
        List<WebElement> listingSize2 = SeleniumConfig.driver.findElements(By.xpath("//*[@id=\"sizes\"]/div/span[@class='m-variation__item -criticalStock']"));
        listingsSize.addAll(listingSize2);
        Random r = new Random();
        int randomValue = r.nextInt(listingsSize.size());
        listingsSize.get(randomValue).click();
        Product product = new Product();
        product.addBasket.click();
        firstPrice = product.showCasePrice.getText();
    }

    @Test
    @Order(7)
    public void comparePrice() {
        Product product = new Product();
        product.goToBasket.click();
        SeleniumConfig.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='m-productPrice__salePrice']")));
        Assertions.assertEquals(firstPrice, basket.basketPrice.getText());
    }

    @Test
    @Order(8)
    public void increaseProductNumber() {
        Select objSelect = new Select(SeleniumConfig.driver.findElement(By.id("quantitySelect0")));
        objSelect.selectByVisibleText("1 adet");
        objSelect.selectByIndex(1);
    }

    @Test
    @Order(9)
    public void deleteProduct() {
        WebElement deleteButton = SeleniumConfig.driver.findElement(By.id("removeCartItemBtn0"));
        deleteButton.click();
    }

    @AfterAll
    public static void afterAll()
    {
        SeleniumConfig.driver.quit();
    }

}
