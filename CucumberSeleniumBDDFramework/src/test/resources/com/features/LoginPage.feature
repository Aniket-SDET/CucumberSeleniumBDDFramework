Feature: Login feature

Background: 
Given user is on welcome page
And user clicks on login button on welcome page


Scenario: Login page title
Given user is on Login page
When user gets the title of the page
Then page title should be "Cogmento CRM"

Scenario: Forgot Password link
Given user is on Login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on Login page
Then user enters username "abhonde320@gmail.com"
And user enters password "Mumbai@123"
And user clicks on login button on login page
Then user gets the title of the page
And page title should be "Cogmento CRM"
