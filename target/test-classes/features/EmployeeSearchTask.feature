Feature: employee search

  Scenario: employee id search
    Given user is navigated to HRMS
    And user is logged in as an admin
    And user navigates to the employee list page
    When the user enters a valid employee id
    And the user clicks the search button
    And user clicks on matching credential
    Then the user should see the employee with the matching credentials

  Scenario: employee name search
    Given user is navigated to HRMS
    And user is logged in as an admin
    And user navigates to the employee list page
    When the user enters a valid employee name
    And the user clicks the search button
    And user clicks on matching credential
    Then the user should see the employee with the matching credentials
