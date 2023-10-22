Feature: Add Items to Cart in SauceDemo

  Scenario: Add Items to Cart
    Given User login in https://www.saucedemo.com/
    When User click button Add to Cart in first list product
    And User click icon cart
    Then In cart page, will show product user which choose