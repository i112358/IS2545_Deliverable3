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
public class Customer {
    
    static WebDriver driver = new HtmlUnitDriver();
    public static String baseUrl = "http://store.demoqa.com/";
    public static String expectedTitle = "ONLINE STORE | Toolsqa Dummy Test site";
    
    public Customer() {
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
    public void titleTest(){
        assertEquals(expectedTitle,driver.getTitle());
    }
}
