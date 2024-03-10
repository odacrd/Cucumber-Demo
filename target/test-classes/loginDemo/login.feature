Feature: Login feature
  Scenario Outline: Login with different credentials
    Given I open the login page
    When I enter the username as "<username>" and password as "<password>"
    And I click the login button
    Then I see the login "<message>" msg

    Examples:
      |username|password|message|
      |students  |Password123|Your username is invalid!|
      |student   |Password123|Logged In Successfully|
      |student  |password|Your password is invalid!|