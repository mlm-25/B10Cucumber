package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.apache.commons.math3.analysis.function.Add;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeePersonalDetailsPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        clickMethod(dash.addEmployeeButton);
    }
    @When("user enters firstname, middle name and lastname")
    public void user_enters_firstname_middle_name_and_lastname() {
        AddEmployeePage page = new AddEmployeePage();
        sendText(page.firstname, "Vini");
        sendText(page.middleName, "Jose");
        sendText(page.lastname, "Olivera");
    }
    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage page = new AddEmployeePage();
        clickMethod(page.checkbox);
    }
    @When("user enters username password and confirm password")
    public void user_enters_username_password_and_confirm_password() {
        AddEmployeePage page = new AddEmployeePage();
        sendText(page.createUsername, "ViniJ123");
        sendText(page.createPassword, "Hum@nhrm123");
        sendText(page.rePassword, "Hum@nhrm123");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage page = new AddEmployeePage();
        clickMethod(page.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        EmployeePersonalDetailsPage page = new EmployeePersonalDetailsPage();
        Assert.assertTrue(page.employee.isDisplayed());
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        clickMethod(dash.pimOption);
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage page = new AddEmployeePage();
        page.employeeId.clear();
    }

    @When("user enters {string}, {string}, {string}, and {string}")
    public void user_enters_and(String firstname, String middleName, String lastname, String photo) {
        AddEmployeePage page = new AddEmployeePage();
        sendText(page.firstname, firstname);
        sendText(page.middleName, middleName);
        sendText(page.lastname, lastname);
        sendText(page.photograph, photo);
    }

    @When("user enters {string}, {string}, and {string}")
    public void user_enters_and(String firstname, String middleName, String lastname) {
        AddEmployeePage page = new AddEmployeePage();
        sendText(page.firstname, firstname);
        sendText(page.middleName, middleName);
        sendText(page.lastname, lastname);
    }

    @When("I add multiple employees and verify them that user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) {

        List<Map<String, String>> employeeNames = employees.asMaps();
        for (Map<String, String> employeeName:employeeNames) {
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage page = new AddEmployeePage();
            sendText(page.firstname, valueFirstName);
            sendText(page.middleName, valueMiddleName);
            sendText(page.lastname, valueLastName);
            clickMethod(page.saveBtn);

            EmployeePersonalDetailsPage pageEmp = new EmployeePersonalDetailsPage();
            Assert.assertTrue(pageEmp.employee.isDisplayed());

            DashBoardPage dash = new DashBoardPage();
            clickMethod(dash.addEmployeeButton);

        }
    }

    @When("user enters {string}, {string}, and {string} for the employee")
    public void user_enters_and_for_the_employee(String firstname, String middleName, String lastname) {
            AddEmployeePage page = new AddEmployeePage();
            sendText(page.firstname, firstname);
            sendText(page.middleName, middleName);
            sendText(page.lastname, lastname);
    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);
        DashBoardPage dash = new DashBoardPage();
        AddEmployeePage emp = new AddEmployeePage();

        Iterator<Map<String, String>> it = newEmployees.iterator();
        while(it.hasNext()){
            Map<String, String> mapNewEmp = it.next();
            sendText(emp.firstname, mapNewEmp.get("FirstName"));
            sendText(emp.middleName, mapNewEmp.get("MiddleName"));
            sendText(emp.lastname, mapNewEmp.get("LastName"));
            sendText(emp.photograph, mapNewEmp.get("Photograph"));
            clickMethod(emp.saveBtn);
        }
    }

    @When("user enters {string}, {string}, {string}")
    public void user_enters(String firstname, String middleName, String lastname) {
        // initilizing global variables using local variables (values coming from feature file)
        GlobalVariables.firstname = firstname;
        GlobalVariables.middleName = middleName;
        GlobalVariables.lastname = lastname;

        AddEmployeePage page = new AddEmployeePage();
        sendText(page.firstname, firstname);
        sendText(page.middleName, middleName);
        sendText(page.lastname, lastname);
        System.out.println("------");
    }

    @When("captures employee id")
    public void captures_employee_id() {
        AddEmployeePage page = new AddEmployeePage();
        GlobalVariables.empId = page.employeeId.getAttribute("value");
        System.out.println("------"+ GlobalVariables.empId+"---------------");
    }

    @Then("verify employee data is matched in ui and db")
    public void verify_employee_data_is_matched_in_ui_and_db() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("------");
        Assert.assertEquals(GlobalVariables.mapDataFromDB.get("emp_firstname"), GlobalVariables.firstname);
        Assert.assertEquals(GlobalVariables.mapDataFromDB.get("emp_middle_name"), GlobalVariables.middleName);
        Assert.assertEquals(GlobalVariables.mapDataFromDB.get("emp_lastname"), GlobalVariables.lastname);
        System.out.println("------");

    }
}
