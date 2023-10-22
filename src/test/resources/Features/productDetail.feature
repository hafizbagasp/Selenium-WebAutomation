Feature: Product Detail

  Scenario: Show Product Detail
    Given User success login in https://www.saucedemo.com/
    When User click Name Product in list first product
    Then Show to page product detail which user choosen