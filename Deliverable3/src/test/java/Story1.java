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
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author Rachel
 */
public class Story1 {
    
    static WebDriver driver = new HtmlUnitDriver();
    public static String baseUrl= "http://store.demoqa.com/tools-qa/?action=register";
    
    public Story1() {
    }
    
     @BeforeClass
    public static void setUpClass() {
        driver.get(baseUrl);
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.manage().deleteAllCookies();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void usernameBlankTest(){
        try {
            //Enter valid email
            driver.findElement(By.id("user_email")).sendKeys("111@try.com");

            //Look for the Register button and click
            WebElement registerButton = driver.findElement(By.id("wp-submit"));
            registerButton.click();

            //Get error message
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login_error']"));
            
            //check if error message is correct
            assertTrue(errorMessage.getText().startsWith("ERROR: Please enter a username."));
            
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }
    }
}
