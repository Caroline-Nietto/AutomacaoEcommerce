Feature: Test Select 2 Products
    Scenario Outline: Selecting Product
    Given I access the giuliana store T
    When I click on the product category T
    Then I select the product1 T
    And I check the product1 name <productTitle> T
    And I check the product1 price <productPrice> T
    Then I click on add to cart T
    Then I fill in the field with the postcode for delivery T
    When I click on the ok button to select the postcode T
    Then I select the delivery period T
    And I click on add to cart after to select the postcode T
    Then I verify the page's title "MEU CARRINHO" in cart T
    And I verify the product1 title <productTitleCart> in cart T
    And I verify the price of the product1 <productPrice> T
    Then I click buy more for this destination T
    And I click on Same Date T
    Then I click on the Category Menu T
    And I select the product2 T
    Then I check the product2 name <productTitle> T
    And I check the price of the product2 <productPrice> T
    Then I click Add to Cart T
    And I select the delivery time T
    And I click ok T
    Then I check the page's title "MEU CARRINHO" in cart T
    And I check the product1 name <productTitleCart> in cart T
    And I check the product1 price <productPrice> in cart T
    And I check the product2 name <productTitleCart> in cart T
    And I check the product2 price <productPrice> in cart T

    Examples:
      | productTitle                  | productPrice | productTitleCart              |
      | "BUQUÊ DE 6 ROSAS VERMELHAS"  | "R$ 109,90"  | "Buquê de 6 Rosas Vermelhas"  |
      | "CESTA SONHO DOS CHOCÓLATRAS" | "R$ 149,90"  | "Cesta Sonho dos Chocólatras" |