@UserRegistration

Feature: User Registeration
	I want to check that the user can register in our e-commerce website.
	
	Scenario:
	Given The user in the home page
	When I click on register link
	And I entered "<firstName>", "<lastName>", "<email>", "<password>"
	Then The registration page is displayed successfully
	
	Examples:
	| firstName | lastName 	| email 			| password		|
	| john 		| doe		| test11@test.com	| 4613054143	|
	| john 		| doe		| test12@test.com	| 4613054143	|