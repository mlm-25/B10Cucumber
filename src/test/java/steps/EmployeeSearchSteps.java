package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.EmployeePersonalDetailsPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        openBrowser();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        clickMethod(login.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash = new DashBoardPage();
        clickMethod(dash.pimOption);
        clickMethod(dash.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.idEmployee, "20149000");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        clickMethod(emp.searchBtn);

    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        EmployeeListPage emp = new EmployeeListPage();
        clickMethod(emp.employee);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.employeeName, "Karim Benzema");
        clickMethod(emp.searchBtn);
    }

    @Then("user then clicks qualifications tab")
    public void user_then_clicks_qualifications_tab() {
        EmployeePersonalDetailsPage emp = new EmployeePersonalDetailsPage();
        clickMethod(emp.qualificationsTab);
    }

}
