Feature: Address
  Scenario: Create address successfully
    Given The user open page Market
    When The user login page
    When The user select account information
    And The user select list address
    When The user click button create address
    When The user enter name "Dinh test"
    When The user enter phone "0376595423"
    When The user select district
    When The user enter address "266 Đội cấn"
    When The user select ward
    When The user click button save
    Then The User checks the message of successful delivery address creation