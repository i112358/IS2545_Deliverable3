/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
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
