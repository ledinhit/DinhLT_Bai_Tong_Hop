Feature: Order
  Scenario: Create order successfully
    Given The user open Web
    When The user login
    When The user select product
    When The user view cart
    When The user select address
    When The user enter note
    When The user click create order
    Then The user check message success

  Scenario: Create order Failed
    Given The user open page
    When The user login to page
    When The user add product
    When The user view cart after add product
    When The user enter note order
    When The user click button create order
    Then The user check message error