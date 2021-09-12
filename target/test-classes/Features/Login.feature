Feature: Login functionality of Application

  Scenario: Login successfully
    Given The user open Web Market
    When The user click account in action bar
    When The user select sign in
    When The user Login page
    Then The user Check first name "dinh test dev"

  Scenario Outline: Login failed
    Given  The user Open Login page and set the variables
    When The user click account in home
    When The user Click sign in with phone
    When The user Enter the username and password "<username>" "<password>"
    Then The user check message error "<messUsernameError>" "<messPasswordError>"
    Examples:
      | username   | password | messUsernameError                      | messPasswordError                |
      |            | 121212   | Số điện thoại phải từ 10 đến 12 ký tự! |                                  |
      | 0376595922 |          |                                        | Mật khẩu phải từ 6 đến 20 ký tự! |
      |            |          | Số điện thoại phải từ 10 đến 12 ký tự! | Mật khẩu phải từ 6 đến 20 ký tự! |
      | 0376595    | 121212   | Số điện thoại phải từ 10 đến 12 ký tự! |                                  |

