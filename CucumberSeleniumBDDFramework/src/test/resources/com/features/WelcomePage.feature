Feature: Welcome feature

Scenario: Welcome page title
Given user is on welcome page
When user gets the title of the page
Then page title should be "#1 Free CRM Power Up your Entire Business Free Forever customer relationship management?111"

Scenario: Login button is present
Given user is on welcome page
Then Login button should be present