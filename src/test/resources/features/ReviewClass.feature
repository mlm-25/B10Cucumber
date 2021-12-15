Feature: Login error verification

  @loginReview
  Scenario: valid username and invalid password
    When user enters valid "admin" and valid "Humanhrm12345"
    And user clicks on login button
    Then user see invalid credentials message on login page

  @loginReview
  Scenario Outline: valid username and invalid password
    When user enters valid "<username>" and valid "<password>"
    And user clicks on login button
    Then user verify dashboard page
    Examples:
    |username|password|
    |admin|Hum@nhrm123|
    |johny1234560000|Syntax1253!!!!|
