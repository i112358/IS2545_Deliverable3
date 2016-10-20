/*
User story 2
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Rachel
 */
public class Story2 {
    
    static WebDriver driver = new HtmlUnitDriver();
    public static String baseUrl= "http://store.demoqa.com/";
    public static String product1 = "http://store.demoqa.com/products-page/product-category/ipod-nano-blue/";
    public static String product2 = "http://store.demoqa.com/products-page/product-category/magic-mouse/";
    public static String checkoutPage = "http://store.demoqa.com/products-page/checkout/";
    
    public Story2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver.get(baseUrl);
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }
    
    //User story 2:
    //As a user
    //I would like to edit products in the shopping cart
    //so that I can buy them
    
    /*
    Given that the user has 0 items in his shopping cart
    When he clicks "Add To Cart" of a product
    Then the user shall have 1 item in his shopping cart
    */
    @Test
    public void addOneItemTest() {
        //Go to a products page
        driver.get(product1);
        
        //click on "Add to Cart button"
        WebElement addToCartButton = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton.click();
        
        //Wait for cart to be updated
        WebDriverWait newwait = new WebDriverWait(driver,5);
        
        //Find cart element
        WebElement itemCnt = driver.findElement(By.xpath("//div[@id='header_cart']/a/em[@class='count']"));
        assertEquals("1",itemCnt.getText());      
    }
    
    /*
    Given that the user has 1 items in his shopping cart
    When he clicks "Add To Cart" of a product
    Then the user shall have 2 items in his shopping cart
    */
    @Test
    public void addOneMoreItemTest() {
        //Add one product to cart
        driver.get(product1);
        WebElement addToCartButton = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton.click();
        
        //Go to a new products page
        driver.get(product2);
        
        //click on "Add to Cart button"
        WebElement addToCartButton2 = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton2.click();
        
        //Wait for cart to be updated
        WebDriverWait newwait2 = new WebDriverWait(driver,5);
        
        //Find cart element
        WebElement itemCnt = driver.findElement(By.xpath("//div[@id='header_cart']/a/em[@class='count']"));
        assertEquals("2",itemCnt.getText());
    }
    
    /*
    Given that the user has 1 items in his shopping cart and is on the checkout page
    When he changes the quantity of that product to 2 and clicks "Update" of a product
    Then the user shall have 2 items in his shopping cart
    */
    @Test
    public void updateItemTest() {
        //Add one item to the shopping cart
        driver.get(product1);
        WebElement addToCartButton = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton.click();
        
        //go to checkout page
        driver.get(checkoutPage);
        
        //Find Quantity text field
        WebElement itemQuant = driver.findElement(By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']/form/input[@type='text']"));
        //assertEquals("1",itemQuant.getAttribute("value")); 
        itemQuant.clear();
        itemQuant.sendKeys("2");
        itemQuant.submit();
        
        //wait for page to update
        WebDriverWait newwait = new WebDriverWait(driver,5);
        
        //Find quantity element, check if updated
        WebElement itemCnt = driver.findElement(By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']/form/input[@type='text']"));
        assertEquals("2",itemCnt.getAttribute("value"));
    }
    
    /*
    Given that the user has 2 different items in his shopping cart and is on the checkout page
    When he clicks "Remove" of a product
    Then the user shall have 1 item in his shopping cart
    */
    @Test
    public void removeItem2to1() {
        //Add one product to cart
        driver.get(product1);
        WebElement addToCartButton = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton.click();
        
        //Add second product to cart
        driver.get(product2);
        WebElement addToCartButton2 = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton2.click();
        
        //go to checkout page
        driver.get(checkoutPage);
        
        //Click remove
        driver.findElement(By.xpath("//td[@class='wpsc_product_remove wpsc_product_remove_0']/form/input[@type='submit']")).submit();
        
        //Wait for cart to be updated
        WebDriverWait newwait = new WebDriverWait(driver,5);
        
        //Find cart element
        WebElement itemCnt = driver.findElement(By.xpath("//div[@id='header_cart']/a/em[@class='count']"));
        assertEquals("1",itemCnt.getText());
    }
    
    /*
    Given that the user has 1 items in his shopping cart and is on the checkout page
    When he clicks "Remove" of a product
    Then the user will see message "Oops, there is nothing in your cart."
    */
    @Test
    public void removeItem1to0() {
        //Add one item to the shopping cart
        driver.get(product1);
        WebElement addToCartButton = driver.findElement(By.className("wpsc_buy_button"));
        addToCartButton.click();
        
        //go to checkout page
        driver.get(checkoutPage);
        
        //Click remove
        driver.findElement(By.xpath("//td[@class='wpsc_product_remove wpsc_product_remove_0']/form/input[@type='submit']")).submit();
        
        //Wait for cart to be updated
        WebDriverWait newwait = new WebDriverWait(driver,5);
        
        //Find shopping cart message
        WebElement cartEmpty = driver.findElement(By.xpath("//article[@id='post-29']/div[@class='entry-content']"));        
        assertEquals("Oops, there is nothing in your cart.",cartEmpty.getText());
    }
}
