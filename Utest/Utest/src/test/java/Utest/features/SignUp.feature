Feature: As a user I want to sign up new user successfully 
	The sign up module must be functional correctly and smooth 
	
Scenario Outline: User sign up successfully in Utest page

	Given User navigate to utest page 
	And User click on sign up for free
	And I enter firstname as "<Firstname>" 
	And I enter lastname as "<Lastname>"
	And I enter email address as "<EmailAddress>" 
	And I select Date of birth month as "<Month>"
	And I select Date of birth day as "<Day>" 
	And I select Date of birth as as "<Year>" 
	And I select Gender
	When I click on Next Location button
	Then The web page redirect to step two successfully
	 
	
	Examples: 
	| Firstname | Lastname | EmailAddress | Month | Day | Year | 
	| Huy | Le | huyle@gmail.com | 11 | 19 | 1991 | 
	
	

Scenario Outline: User input invalid email and validation messages must display correctly

	Given User navigate to utest page 
	And User click on sign up for free
	And I enter email address as "<EmailAddress>" 
	When I click on Next Location button
	Then Validation message displays as "<Message>" 
	 
	
	Examples: 
	| EmailAddress | Message | 
	| huyle | Enter valid email | 
	| example@com | Enter valid email |
	