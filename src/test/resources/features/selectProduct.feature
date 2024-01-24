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
    Then I validate the page title <pageTitle> in cart
    And I validate the product title <productTitleCart> in cart
    And I validate the price of the product <productPriceCart> in cart

    Examples:
      | productTitle                 | productPrice | pageTitle      |  productTitleCart             | productPriceCart |
      | "Buquê de 6 Rosas Vermelhas" | "R$ 109,90"  | "MEU CARRINHO" |  "Buquê de 6 Rosas Vermelhas" | "R$ 109,90"      |