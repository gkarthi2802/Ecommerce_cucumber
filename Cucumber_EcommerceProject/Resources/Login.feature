Feature: Verifying the login Functionality
Scenario: verifying the login Functionality
Given  user opens the browser and enter the url http://automationpractice.com/index.php and user is already registered 
When user   clicks on signin button
And user enters username and password
And click on sign in button
Then it should navigate to the page with title Myaccount-mystore