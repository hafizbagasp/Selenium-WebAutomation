Feature: Login to SauceDemo with invalid credentials

  Scenario: Invalid Login
    Given user should be open https://www.saucedemo.com/
    When user input invalid username and password
    And user click button Login
    Then user should see an error message