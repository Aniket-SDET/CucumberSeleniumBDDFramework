Feature: Deal creation using maps in data tables

  Scenario: Create New Deal using maps in data tables
    Given User is on FreeCRM login page
    When user enters correct credentials
      | Username             | Password   |
      | abhonde320@gmail.com | Mumbai@123 |
    And clicks on login btn
    Then user is logged in successfully
    And mouse hovers on menu tab and clicks on add button to create new deal
    Then Create new deal webpage opens
    And user enters required deal details
      | Deal_Title  | Description | Amount | Type        |
      | Aniket Deal | Test1 Deal  |    100 | Priority    |
      | Omkar Deal  | Test2 Deal  |     50 | Opportunity |
      | Puneet Deal | Test3 Deal  |     70 | Old         |
      | Amey Deal   | Test4 Deal  |     35 | Priority    |
    Then user closes the browser
