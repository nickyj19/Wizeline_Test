package Utest.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	public static WebDriverWait wait;
	
	
	public static WebDriver initDriver(String browserName)
	{
		if(browserName.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/nickyjr/Desktop/Selenium/JavaLab/Utest/Utest/src/test/java/Utest/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();	
			
		}
		return driver;
	}
  

    public static void Navigate(WebDriver driver, String url)
    {
        driver.get(url);
    }

    public static void Quit(WebDriver driver)
    {
    	driver.quit();
    }
   
    
    public static void click(WebDriver driver, String locatorType, String locatorValue) {

    	WebElement element = null;
    	try
    	{
    		element = waitForVisibilityOfElementLocated(driver, locatorType, locatorValue, 5);
    		waitForElementToBeClickable(driver, element, 5);
    		element = driver.findElement(Parse(locatorType, locatorValue));
    		if(element.isDisplayed())
    		{
    			element.click();
    		}
    	}catch(Exception ex)
    	{
    		System.out.println("Element cannot be clicked !!");
    	}
    }
    


    public static void pressEnterOnKeyboard(WebDriver driver, String locatorType, String locatorValue)
    {
    	WebElement element = null;
    	try
    	{
    		element = waitForVisibilityOfElementLocated(driver, locatorType, locatorValue, 5);
    		element = driver.findElement(Parse(locatorType, locatorValue));
    		element.sendKeys(Keys.ENTER);
    	}catch(Exception ex)
    	{
    		System.out.println("Cannot replicate ENTER action on keyboard !!");
    	}
    }
    
    
    public static void sendKeys(WebDriver driver, String locatorType, String locatorValue, String keyToSend)
    {
    	WebElement element = null;
    	try
    	{
    		element = waitForVisibilityOfElementLocated(driver, locatorType, locatorValue, 5);
    		if(element.isDisplayed())
    		{
    			element.clear();
        		element.sendKeys(keyToSend);
    		}
    		
    	}catch(Exception ex)
    	{
    		System.out.println("Text cannot be sent to Element !!");
    	}
    }

    public static boolean isElementSelected(WebDriver driver,String locatorType, String locatorValue)
    {
    	WebElement element = null;
    	boolean isElementSelected;
        try
        {
            element = waitForVisibilityOfElementLocated(driver, locatorType, locatorValue, 5);
            isElementSelected = element.isSelected();
            isElementSelected = waitForElementToBeSelected(driver, element, 5);
           	if(isElementSelected)
           	{
           		return isElementSelected;
           	}
           	
        }catch(Exception ex)
        {
        	System.out.println("Element cannot be selected !!");
        }
        return false;
    }
    
    
    public static String getText(WebDriver driver,String locatorType, String locatorValue)
    {
    	
    	WebElement element= null;
    	try
    	{
    		element = waitForVisibilityOfElementLocated(driver, locatorType, locatorValue, 5);
    		
    	}catch(Exception ex)
    	{
    		System.out.println("Cannot Get Element's Text !!");
    	}
    	return element.getText();
        
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, long timeOutInSecond)
    {
    	try
    	{
    		wait = new WebDriverWait(driver, timeOutInSecond);
    		wait.until(ExpectedConditions.elementToBeClickable(element));
    	}catch(Exception ex)
    	{
    		System.out.println("Element cannot be clickable !!");
    	}
    }
    
    
    public static boolean waitForElementToBeSelected(WebDriver driver, WebElement element, long timeOutInSecond)
    {
    	boolean isElementSelected = false;
    	try
    	{
    		wait = new WebDriverWait(driver, timeOutInSecond);
    		boolean elementToBeSelected = wait.until(ExpectedConditions.elementToBeSelected(element)); 
    		if(elementToBeSelected)
    		{
    			isElementSelected = true;
    		}
    	}catch(Exception ex)
    	{
    		System.out.println("Element cannot be selected !!");
    	}
        return isElementSelected;
    }
    
    public static WebElement waitForVisibilityOfElementLocated(WebDriver driver, String locatorType, String value,long timeOutInSecond)
    {
    	WebElement element = null;
    	try
    	{
    		wait = new WebDriverWait(driver, timeOutInSecond);
    		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Parse(locatorType, value)));
    		element = driver.findElement(Parse(locatorType, value));
    		
    	}catch(Exception ex)
    	{
    		System.out.println("Element not found !!");
    	}
    	return element;
    }
    
    
    public static By Parse(String locatorType, String value)
    {    	
    	By locator = null;
        switch (locatorType.toLowerCase())
        {
            case "id":
                locator = By.id(value);
                break;
            case "name":
            	locator = By.name(value);
                break;
            case "classname":
            	locator = By.className(value);
                break;
            case "linktext":
            	locator = By.linkText(value);
                break;
            case "partiallinktext":
                locator = By.partialLinkText(value);
                break;
            case "tagname":
                locator = By.tagName(value);
                break;
            case "css":
                locator = By.cssSelector(value);
                break;
            case "xpath":
                locator = By.xpath(value);
                break;
            default:
                String message = String.format("%s Unsupported or invalid locator type", locatorType);
        }
        return locator;
    }
}



