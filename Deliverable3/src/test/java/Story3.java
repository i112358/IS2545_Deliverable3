/*
User Story 3
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
public class Story3 {
    
    static WebDriver driver = new HtmlUnitDriver();
    public static String loginPage = "http://store.demoqa.com/tools-qa/";
    
    public Story3() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver.get(loginPage);
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get(loginPage);
    }
    
    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    // User story 3:
    //As a user
    //I would like to log in
    //so that I can place orders
    
    /*
    Given that the user is in the login page
    When the user enters invalid login information
    Then the user should get error message "Invalid login credentials."
    */
    @Test
    public void loginTest() {
        //enter invalid username and password
        driver.findElement(By.id("user_login")).sendKeys("111");
        driver.findElement(By.id("user_pass")).sendKeys("111");
        driver.findElement(By.id("loginform")).submit();
        
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login_error']"));
        assertEquals("ERROR: Invalid login credentials.",errorMessage.getText());
    }
}
