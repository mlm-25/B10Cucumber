Feature: Edit employee information

  @editInfo
  Scenario Outline: edit employee info
    When user is logged in with the valid admin credentials
    Then user navigates to employee list page
    And user enters a valid employee "<id>"
    And click on search button
    When user clicks on matching credential
    Then user see employee information is displayed
    Then user clicks on edit and save button
    And user enters a "<driversLicenseNumber>" and "<driversLicenseExpiration>"
    And user enters the employees "<gender>", "<nationality>", "<maritalStatus>", and "<dateOfBirth>"
    And user enters the employees "<nickName>", "<smoker>", and "<militaryService>"
    #Then user clicks on edit and save button


    Examples:
      |id|driversLicenseNumber|driversLicenseExpiration|gender|nationality|maritalStatus|dateOfBirth|nickName|smoker|militaryService|
      |20026000|123 45 678|2023-04-17|Male|Belgian|Married|1991-06-28|The Ginger Pele|no|n/a|
      |20149000|876 54 321|2025-09-04|Male|Algerian|Single|1991-02-21|Algerian Robben|no|n/a|


