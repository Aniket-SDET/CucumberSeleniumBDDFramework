Feature: Free CRM login feature

  #Scenario: Free CRM login test scenario
  #Given user is on login page
  #When title of login page is Free CRM Power Up your Entire Business Free Forever
  #Then user enters "abhonde320@gmail.com" and "Mumbai@123"
  #Then user clicks on login button
  #Then user is on home page
  #With Examples Keyword
  Scenario Outline: Free CRM login test scenario
    Given user is on login page
    When title of login page is Free CRM Power Up your Entire Business Free Forever
    Then user enters "<username>" and "<password>"
    Then user clicks on login button
    Then user is on home page
    Then user logs out
    Then user close browser

    Examples: 
      | username             | password   |
      | abhonde320@gmail.com | Mumbai@123 |
      #| xyz@gmail.com        | Kalyan@123 |
