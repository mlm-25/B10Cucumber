Feature: Work Experience verification

  @Qual
  Scenario: Search employee by id
    When user is logged in with admin credentials
    And user navigates to the employee list page screen
    And user enters a valid employee id
    And the user clicks the on search button
    And the user should see the employee information
    And user then on the clicks qualifications tab
    #And user clicks on add button
    #Then user sends information on company name
    #And user then sends information to the job title
    #Then user sends information to from calendar
    #And user then sends information to second calendar
    #Then user sends information to the comments
    #Then user selects the save button
#//22028000