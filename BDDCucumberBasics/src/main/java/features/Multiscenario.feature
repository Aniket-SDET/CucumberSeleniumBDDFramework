Feature: Create contacts deals and tasks on FreeCRM website

  Background: Login
    Given: User is on login page of FreeCRM
    Then: User inputs correct credentials
    And: User is loggedin successfully to homepage of FreeCRM

	@Smoke
  Scenario: Creat tasks
    When user mouse hovers on menu tab and clicks on new task button
    Then user enters tasks details
    And saves the new task

	@Smoke @Regression
  Scenario: Create contacts
    When user mouse hovers on menu tab and clicks on new contact button
    Then user enters contacts details
    And saves the new contact

	@Regression
  Scenario: Create new deal
    When user mouse hovers on menu tab and clicks on new deal button
    Then user enters all deal details
    And saves the new deal
