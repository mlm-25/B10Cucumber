package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.EmployeePersonalDetailsPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchStepsTask extends CommonMethods {

    @Given("user is logged in as an admin")
    public void user_is_logged_in_as_an_admin() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        clickMethod(login.loginBtn);
    }

    @Given("user navigates to the employee list page")
    public void user_navigates_to_the_employee_list_page() {
        DashBoardPage dash = new DashBoardPage();
        clickMethod(dash.pimOption);
        clickMethod(dash.employeeListOption);
    }

    @When("the user enters a valid employee id")
    public void the_user_enters_a_valid_employee_id() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.idEmployee, "20026000");
    }

    @When("the user clicks the search button")
    public void the_user_clicks_the_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        clickMethod(emp.searchBtn);
    }

    @When("user clicks on matching credential")
    public void user_clicks_on_matching_credential() {
        EmployeeListPage emp = new EmployeeListPage();
        clickMethod(emp.employee);
    }

    @Then("the user should see the employee with the matching credentials")
    public void the_user_should_see_the_employee_with_the_matching_credentials() {
        EmployeePersonalDetailsPage emp = new EmployeePersonalDetailsPage();
        Assert.assertTrue(emp.employee.isDisplayed());
    }

    @When("the user enters a valid employee name")
    public void the_user_enters_a_valid_employee_name() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.employeeName, "Kevin De Bruyne");
    }

}
