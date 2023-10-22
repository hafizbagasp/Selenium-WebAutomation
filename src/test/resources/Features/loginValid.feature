Feature: Login to SauceDemo with valid credentials

  Scenario: Successful Login
    Given User should be open https://www.saucedemo.com/ in web browser
    When User input valid username and password
    And User click button Login
    Then Homepage should be displayed