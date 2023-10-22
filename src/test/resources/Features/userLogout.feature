Feature: Logout from SauceDemo

  Scenario: Successful Logout
    Given User is logged in to SauceDemo
    When User click the logout button
    Then User should be logged out successfully