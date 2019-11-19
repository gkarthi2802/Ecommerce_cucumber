Feature: Add items to the cart and verify the no of items in cart
Scenario: Add items to the cart
Given user logged into the website 
When user move to item and add to cart
And select one more item and add to cart
Then it should show two items in the cart 
And let u confirm the order
