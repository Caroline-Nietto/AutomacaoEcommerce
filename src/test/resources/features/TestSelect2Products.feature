Feature: Test Select 2 Products
  Scenario Outline: Selecting Product
Feature: Select Product
  Scenario Outline: Selecting Product with Success DDT
    Given I access the giuliana store
    When I click on the product category
    Then I select the product
    And I check the product name <productTitle>
    And I check the product price <productPrice>
    Then I click on add to cart
    Then I fill in the field with the postcode for delivery
    When I click on the ok button to select the postcode
    Then I select the delivery period
    And I click on add to cart after to select the postcode
    Then I verify the page's title "MEU CARRINHO" in cart
    And I verify the product title <productTitleCart> in cart
    And I verify the price of the product <productPriceCart> in cart
    Then I click buy more for this destination
    And I click on Same Date
    Then I click on the Category Menu
    And select the product
    Then I check the Product name <productTitle>
    And I check the price of the product <productPrice>
    Then I click Add to Cart
    And I select the delivery time
    And I click ok
    Then I check the page's title "MEU CARRINHO" in cart
    And I check the product name <productTitleCart> in cart
    And I check the product price <productPriceCart>

    Examples:
      | productTitle                  | productPrice | productTitleCart              | productPriceCart |
      | "BUQUÊ DE 6 ROSAS VERMELHAS"  | "R$ 109,90"  | "Buquê de 6 Rosas Vermelhas"  | "R$ 109,90"      |
      | "CESTA SONHO DOS CHOCÓLATRAS" | "R$ 149,90"  | "Cesta Sonho dos Chocólatras" | "R$ 149,90"      |