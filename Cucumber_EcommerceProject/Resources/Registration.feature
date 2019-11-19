Feature: verifying the user Registration functionality

Scenario: verifying the Registration of user 
 Given user opens the browser and enter the url http://automationpractice.com/index.php
 When user clicks on signin button
 And user enters the emailid and click on create an account
 And fill the registration details 
 And click on Register button
 Then User should get registered in the website and it displays a success message
 
