package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import utils.CommonMethods;
import utils.ConfigReader;

public class QulificationsWorkExSteps extends CommonMethods {

    @When("user is logged in with admin credentials")
    public void user_is_logged_in_with_admin_credentials() {
        LoginPage login = new LoginPage();
        login.login(ConfigReader.getPropertyValue("username"), ConfigReader.getPropertyValue("password"));
    }

    @When("user navigates to the employee list page screen")
    public void user_navigates_to_the_employee_list_page_screen() {
        DashBoardPage dash = new DashBoardPage();
        clickMethod(dash.pimOption);
        clickMethod(dash.employeeListOption);
    }

    @When("user enters a valid employee id")
    public void user_enters_a_valid_employee_id() {
        EmployeeListPage list = new EmployeeListPage();
        sendText(list.idEmployee, "17865");
    }

    @When("the user clicks the on search button")
    public void the_user_clicks_the_on_search_button() {
        EmployeeListPage list = new EmployeeListPage();
        clickMethod(list.searchBtn);
    }

    @When("user then on the clicks qualifications tab")
    public void user_then_on_the_clicks_qualifications_tab() {
        EmployeePersonalDetailsPage emp = new EmployeePersonalDetailsPage();
        clickMethod(emp.jobTab);
        //clickMethod(emp.qualificationsTab);
    }

    @And("user clicks on add button")
    public void user_clicks_on_add_button() throws InterruptedException {
        QualificationsPage page = new QualificationsPage();
        clickMethod(page.addWorkExperienceCSS);
    }

    @When("the user should see the employee information")
    public void the_user_should_see_the_employee_information() {
        EmployeeListPage list = new EmployeeListPage();
        clickMethod(list.employee);
    }

    @Then("user sends information on company name")
    public void user_sends_information_on_company_name() {
        QualificationsPage page = new QualificationsPage();
        sendText(page.companyWorkExperience, "sdfghj");
    }

    @Then("user then sends information to the job title")
    public void user_then_sends_information_to_the_job_title() {
        QualificationsPage page = new QualificationsPage();
        sendText(page.jobTitleWorkExperience, "xfghj");
    }

    @Then("user sends information to the comments")
    public void user_sends_information_to_the_comments() {
        QualificationsPage page = new QualificationsPage();
        sendText(page.commentWorkExperience, "zaserfvc bjm ,");
    }

    @Then("user sends information to from calendar")
    public void user_sends_information_to_from_calendar() throws InterruptedException {
        QualificationsPage page = new QualificationsPage();
        calenderMethod(page.fromCalender, page.fromMonth, page.fromDays, "Jun", "17");
    }

    @Then("user then sends information to second calendar")
    public void user_then_sends_information_to_second_calendar() {
        QualificationsPage page = new QualificationsPage();
        calenderMethod(page.toCalendar, page.toMonths, page.toDays, "Oct", "29");
    }

    @Then("user selects the save button")
    public void user_selects_the_save_button() {
        QualificationsPage page = new QualificationsPage();
        clickMethod(page.saveBtnWorkExperience);
    }
}
