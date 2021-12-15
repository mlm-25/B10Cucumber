Feature: login

  Scenario: login as admin to hrms
    Given user is navigated to the hrms login page
    When user has valid admin credentials
    And  user clicks login
    Then the user should see the welcome admin screen

  Scenario: login as ess to hrms
    Given user is navigated to the hrms login page
    When the user has valid ess credentials
    And user clicks login
    Then the user should see the welcome ess screen

  Scenario: invalid login to hrms
    Given user is navigated to the hrms login page
    When user has invalid credentials
    And user clicks login
    Then the user should see invalid credentials message