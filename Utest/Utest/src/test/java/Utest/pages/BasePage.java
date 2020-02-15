package Utest.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
		public WebDriver WebDriver;
		
		protected BasePage(WebDriver driver)
		{
			WebDriver = driver;
		}
}
