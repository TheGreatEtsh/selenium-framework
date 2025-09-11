@EndToEnd

Feature: End to End
	I want to login, add products to cart, checkout, and download invoice.
	
Scenario:
	Given The user is on the login page
	When The user can login with right credentials: "<email>", "<password>"
	And The user search for the "<product>" and choose the "<productName>" from the auto suggest
	And The user can add the product to cart
	And The user go to shopping cart page to checkout
	And The user enter checkout details and confirm checkout entering "<phoneNumber>", "<zipCode>", "<stateProvinceId>", "<address>", "<city>", "<lastName>", "<firstName>", "<email>"
	Then The confirmation message should appear
	And The should be able to download the invoice
	
	Examples:
	|		email		|	password	|	product	|		productName		|	phoneNumber |	zipCode	|	stateProvinceId	|	address	|	city	|	firstName	|	lastName	|
	|	test01@test.com	|	4613054143	|	apple	|	Apple MacBook Pro	|		test	|	test	|		Alaska		|	test	|	test	|		john	|		Doe		|
	
	