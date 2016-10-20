/*
User story 1
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
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get(baseUrl);
    }
    
    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    //User story 1:
    //As a user
    //I would like to register
    //so that I can check out faster
    
    /*
    Given that the user is on the register page
    When he leaves the username field blank and registers
    Then he will see error message "ERROR: Please enter a username."
    */
    @Test
    public void usernameBlankTest(){
        try {
            //Enter valid email
            driver.findElement(By.id("user_email")).sendKeys("12345@try.com");

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
    
    /*
    Given that the user is on the register page
    When he leaves the email field blank and registers
    Then he will see an error message "ERROR: Please type your email address."
    */
    @Test
    public void emailBlankTest(){
        try {
            //Enter valid username
            driver.findElement(By.id("user_login")).sendKeys("Idontknow");

            //Look for the Register button and click
            WebElement registerButton = driver.findElement(By.id("wp-submit"));
            registerButton.click();

            //Get error message
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login_error']"));
            
            //check if error message is correct
            assertTrue(errorMessage.getText().startsWith("ERROR: Please type your email address."));
            
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }
    }
    
    /*
    Given that the user is on the register page
    When he enters an invalid email address and registers
    Then he will see an error message "ERROR: The email address isn’t correct."
    */
    @Test
    public void emailInvalidTest(){
        try {
            //Enter valid username
            driver.findElement(By.id("user_login")).sendKeys("Idontknow");
            //enter invalid email
            driver.findElement(By.id("user_email")).sendKeys("12345");

            //Look for the Register button and click
            WebElement registerButton = driver.findElement(By.id("wp-submit"));
            registerButton.click();

            //Get error message
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login_error']"));
            
            //check if error message is correct
            assertTrue(errorMessage.getText().startsWith("ERROR: The email address isn’t correct."));
            
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }
    }
    
    /*
    Given that the user is on the register page
    When he enters the wrong answer to the security question and registers
    Then he will see an error message "ERROR: Your answer was incorrect - please try again."
    */
    @Test
    public void answerWrongTest(){
        try {
            //Enter valid username
            driver.findElement(By.id("user_login")).sendKeys("Idontknow");
            //enter valid email
            driver.findElement(By.id("user_email")).sendKeys("12345@try.com");

            //Look for the Register button and click
            WebElement registerButton = driver.findElement(By.id("wp-submit"));
            registerButton.click();

            //Get error message
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='login_error']"));
            
            //check if error message is correct
            assertTrue(errorMessage.getText().startsWith("ERROR: Your answer was incorrect - please try again."));
            
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }
    }

    /* Unable to implement
    Given that the user is on the register page
    When he enters a username, valid email address and the correct answer to the security question, and registers
    Then he will see message "Registration complete. Please check your e-mail."
    */
}
