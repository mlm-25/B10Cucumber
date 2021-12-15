Feature: Login validation

  @smoke @sprint3
  Scenario: valid admin login
    #Given user is navigated to HRMS
    When user enters valid username and password
    And user clicks on login button
    Then admin user is successfully logged in

  @regression @sprint2
  Scenario: valid ess login
    #Given user is navigated to HRMS
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  @smoke @sprint1
  Scenario: valid username and in valid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user see invalid credentials message on login page


