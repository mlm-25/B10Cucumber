Feature: Syntax HRM API workflow

  Background:
    Given a JWT is created

  @APIWorkFlow
  Scenario: Creating an employee
    Given a request is prepared for creating an employee
    When a POST call is made for creating an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


  @APIWorkFlow
  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for for thus employee is 200
    And the retrieved employee ID "employee.employee_id" should match the globally stored employee id
    And the retrieved data at "employee" object matches the data used to create an employee with employee id "employee.employee_id"
    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_job_title|emp_status|
    |first        |last        |middle         |Male      |1999-01-12  |API Tester   |Employee  |


  @Dynamic
  Scenario: Create dynamic scenario
    Given a request is prepared for creating an employee with dynamic data "Vinicus", "Jose", "Olivera", "M", "2000-07-12", "Employee", "API Tester"
