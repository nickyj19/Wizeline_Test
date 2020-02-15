package Utest.steps;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Utest.pages.SignUpPage;
import Utest.utility.Utilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSteps{
	public SignUpPage signUpPage;
	public WebDriver driver;
	@Before
	public void setup()
	{
		driver = Utilities.initDriver("chrome");
		signUpPage = new SignUpPage(driver);		
		System.out.println("driver : " + driver);
	}
	
	
	@Given("^User navigate to utest page$")
	public void user_navigate_to_utest_page() throws Throwable {
		signUpPage.Navigate("https://www.utest.com/");
	   
	}

	@Given("^User click on sign up for free$")
	public void user_click_on_sign_up_for_free() throws Throwable {
	    signUpPage.ClickSignUpLink();
	}
	
	
	@Given("^I enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String firstname) throws Throwable {
		signUpPage.InputFirstName(firstname);
	}

	@Given("^I enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lastname) throws Throwable {
	     signUpPage.InputLastName(lastname);
	}

	@Given("^I enter email address as \"([^\"]*)\"$")
	public void i_enter_email_address_as(String emailAddress) throws Throwable {
	     signUpPage.InputEmailAddress(emailAddress);
	}

	@Given("^I select Date of birth month as \"([^\"]*)\"$")
	public void i_select_Date_of_birth_month_as(String month) throws Throwable {
	     signUpPage.SelectMonth(month);
	}

	@Given("^I select Date of birth day as \"([^\"]*)\"$")
	public void i_select_Date_of_birth_day_as(String day) throws Throwable {
		signUpPage.SelectDay(day);
	}

	@Given("^I select Date of birth as as \"([^\"]*)\"$")
	public void i_select_Date_of_birth_as_as(String year) throws Throwable {
		signUpPage.SelectYear(year);
	}

	@Given("^I select Gender$")
	public void i_select_Gender() throws Throwable {
		signUpPage.SelectGender("Male");
	}

	@When("^I click on Next Location button$")
	public void i_click_on_Next_Location_button() throws Throwable {
	     signUpPage.ClickNextLocation();
	}

	@Then("^The web page redirect to step two successfully$")
	public void the_web_page_redirect_to_step_two_successfully() throws Throwable {
	     String stepTwoText = "Step 2:";
	     String stepTwoAddressText = "Add your address";
	     assertEquals(signUpPage.GetStepTwoText(), stepTwoText);
	     assertEquals(signUpPage.GetStepTwoAddessText(), stepTwoAddressText);
	}
	
	@Then("^Validation message displays as \"([^\"]*)\"$")
 	public void validation_message_displays_as(String expectedMessage) throws Throwable {
		String actualMessage = signUpPage.GetEnterVaLidEmailMessage();
		assertEquals(actualMessage, expectedMessage);
 	}
	
	@After
	public void CloseBrowser()
	{
		signUpPage.QuitBrowser();
	}

}
