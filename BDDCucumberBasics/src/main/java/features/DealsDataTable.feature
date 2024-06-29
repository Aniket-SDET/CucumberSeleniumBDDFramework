Feature: Deal creation

  Background: User login
    Given User is on login FreeCRM page
    When user enters proper credentials
      | abhonde320@gmail.com | Mumbai@123 |
    And clicks on login button
    Then user is logged in successfully to home page

  Scenario: Create New Deal
    When user mouse hovers on icon tab and clicks on add button to create new deal
    Then Create new deal page opens
    And user enters deal details
      | Aniket Deal | Test1 Deal | 100 | Priority |
    Then saves the deal

