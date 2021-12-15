Feature: Employee Search

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1027
  Scenario: first scenario of adding the employee
    When user enters firstname, middle name and lastname
    And user clicks on save button
    Then employee added successfully

  @1028
  Scenario: second scenario of adding the employee
    And user enters "Vinícius", "José", "Oliveira", and "C:\Users\young\Desktop\Images\Vini.jpg"
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: third scenario of adding the employee
    And user enters firstname, middle name and lastname
    And user selects checkbox
    When user enters username password and confirm password
    And user clicks on save button
    Then employee added successfully

  @1029
  Scenario Outline: second scenario of adding the employee keys
    And user enters "<firstName>", "<middleName>", and "<lastName>" for the employee
    And user clicks on save button
    Then employee added successfully
    Examples:
    |firstName|middleName|lastName|
    |dfghjk|wertyui|sdfghj|

  @1030
  Scenario: adding an employee using data table
    When I add multiple employees and verify them that user has been added successfully
      |firstName|middleName|lastName|
      |first1|middle1|last1|
      |first2|middle2|last2|
      |first3|middle3|last3|
      |first4|middle4|last4|
      |first5|middle5|last5|

  @excel
  Scenario: Adding an employee from excel file
    When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee

  @DB @regression
  Scenario:  Adding employee validating in DataBase
    When user enters "Mike", "meme", "Lopez"
    And captures employee id
    And user clicks on save button
    And employee added successfully
    Then query database and get data
    And verify employee data is matched in ui and db


  @101
  Scenario: third scenario of adding the employee
    And user enters firstname, middle name and lastname
    And user selects checkbox
    When user enters username password and confirm password
    And user clicks on save button
    Then employee added successfully
    Then verify employee data is in DB

