package Utest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utest.objectRepository.OR_SignUp;
import Utest.utility.Utilities;
import cucumber.api.java.After;

public class SignUpPage extends BasePage{
	
	public By By;
	public SignUpPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void Navigate(String url)
	{
		Utilities.Navigate(WebDriver, url);
	}
	
	public void ClickSignUpLink()
	{
		Utilities.click(WebDriver, "xpath" , OR_SignUp.SIGNUP_LINK);
	}
	
	public void InputFirstName(String keyToSend)
	{
		Utilities.sendKeys(WebDriver, "id", OR_SignUp.FIRSTNAME, keyToSend);
	}
	
	public void InputLastName(String keyToSend)
	{
		Utilities.sendKeys(WebDriver, "id", OR_SignUp.LASTNAME, keyToSend);
	}
	
	public void InputEmailAddress(String keyToSend)
	{
		Utilities.sendKeys(WebDriver, "id", OR_SignUp.EMAIL, keyToSend);
	}
	
	public void SelectMonth(String keyToSend)
	{
		Utilities.click(WebDriver, "id" , OR_SignUp.MONTH_DROPDOWN);
		Utilities.sendKeys(WebDriver, "xpath", OR_SignUp.MONTH, keyToSend); 
		Utilities.pressEnterOnKeyboard(WebDriver, "xpath", OR_SignUp.MONTH);
	}
	
	public void SelectDay(String keyToSend)
	{
		Utilities.click(WebDriver, "id" , OR_SignUp.DAY_DROPDOWN);
		Utilities.sendKeys(WebDriver, "xpath", OR_SignUp.DAY, keyToSend); 
		Utilities.pressEnterOnKeyboard(WebDriver, "xpath", OR_SignUp.DAY);
	}
	
	public void SelectYear(String keyToSend)
	{
		Utilities.click(WebDriver, "id" , OR_SignUp.YEAR_DROPDOWN);
		Utilities.sendKeys(WebDriver, "xpath", OR_SignUp.YEAR, keyToSend); 
		Utilities.pressEnterOnKeyboard(WebDriver, "xpath", OR_SignUp.YEAR);
	}
	
	public void SelectGender(String gender)
	{
		if(gender.toLowerCase().equals("male"))
		{
			Utilities.click(WebDriver, "xpath" , OR_SignUp.GENDER_DROPDOWN);
			Utilities.click(WebDriver, "xpath" , OR_SignUp.MALE_GENDER);
		}
		else
		{
			Utilities.click(WebDriver, "xpath" , OR_SignUp.GENDER_DROPDOWN);
			Utilities.click(WebDriver, "xpath" , OR_SignUp.FEMALE_GENDER);
		}
	}
	
	public void ClickNextLocation()
	{
		Utilities.click(WebDriver, "css" , OR_SignUp.NEXTLOCATION_BUTTON);
	}
	
	public String GetStepTwoText()
	{
		return Utilities.getText(WebDriver, "xpath", OR_SignUp.STEP2_LABEL);
	}
	
	public String GetStepTwoAddessText()
	{
		return Utilities.getText(WebDriver, "css", OR_SignUp.STEP2_ADDRESS_LABEL);
	}
	
	public String GetEnterVaLidEmailMessage()
	{
		return Utilities.getText(WebDriver, "id", OR_SignUp.EVM_ENTERVALIDEMAIL);
	}
	
	public void QuitBrowser()
	{

		Utilities.Quit(WebDriver);
	}
	
	
	
}
