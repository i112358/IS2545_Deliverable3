# IS2545 - Deliverable 3: BDD Testing

User story 1:
As a user
I would like to register
so that I can check out faster

	Scenario 1:
	Given that the user is on the register page
	When he leaves the username field blank and registers
	Then he will see error message "ERROR: Please enter a username."

	Scenario 2:
	Given that the user is on the register page
	When he leaves the email field blank and registers
	Then he will see an error message "ERROR: Please type your email address."
	
	Scenario 3:
	Given that the user is on the register page
	When he enters an invalid email address and registers
	Then he will see an error message "ERROR: The email address isn’t correct."	

	Scenario 4:
	Given that the user is on the register page
	When he enters the wrong answer to the security question and registers
	Then he will see an error message "ERROR: Your answer was incorrect - please try again."
	
	Scenario 5:
	Given that the user is on the register page
	When he enters a username, valid email address and the correct answer to the security question, and registers
	Then he will see message "Registration complete. Please check your e-mail."

User story 2:
As a user
I would like to edit products in the shopping cart
so that I can buy them
	
	Scenario 1:
	Given that the user has 0 items in his shopping cart
	When he clicks "Add To Cart" of a product
	Then the user shall have 1 item in his shopping cart
	
	Scenario 2:
	Given that the user has 1 items in his shopping cart
	When he clicks "Add To Cart" of a product
	Then the user shall have 2 items in his shopping cart
	
	Scenario 3:
	Given that the user has 1 items in his shopping cart and is on the checkout page
	When he changes the quantity of that product and clicks "Update" of a product
	Then the user shall have 2 items in his shopping cart
	
	Scenario 4:
	Given that the user has 2 different items in his shopping cart and is on the checkout page
	When he clicks "Remove" of a product
	Then the user shall have 1 item in his shopping cart
	
	Scenario 5:
	Given that the user has 1 items in his shopping cart and is on the checkout page
	When he clicks "Remove" of a product
	Then the user will see message "Oops, there is nothing in your cart."
	

User story 3:
As a user
I would like to log in
so that I can place orders

	Scenario 1:
	Given that the user is in the login page
	When the user enters invalid login information
	Then the user should get error message "Invalid login credentials."
