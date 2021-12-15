package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.EmployeeListPage;
import pages.EmployeePersonalDetailsPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class EditEmployeeInformationSteps extends CommonMethods {

    @When("user is logged in with the valid admin credentials")
    public void user_is_logged_in_with_the_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        clickMethod(login.loginBtn);
    }

    @And("user enters a valid employee {string}")
    public void user_enters_valid_employee_id(String id) {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.idEmployee, id);
    }

    @Then("user clicks on edit and save button")
    public void user_clicks_on_edit_and_save_button() {
        EmployeePersonalDetailsPage page = new EmployeePersonalDetailsPage();
        clickMethod(page.editAndSaveBtn);
    }

    @And("user enters a {string} and {string}")
    public void user_enters_a_driversLicenseNumber_and_driversLicenseExpiration(String licenseNumber, String exDate) {
        EmployeePersonalDetailsPage page = new EmployeePersonalDetailsPage();
        sendText(page.driversLicenseNumber, licenseNumber);
        sendText(page.driversLicenseEx, exDate);
    }

    @Then("user enters the employees {string}, {string}, {string}, and {string}")
    public void user_enters_the_employees_and(String gender, String nation, String maritalStatus, String dateOfBirth) {
        EmployeePersonalDetailsPage page = new EmployeePersonalDetailsPage();
        if(gender.equalsIgnoreCase("male")){
            clickMethod(page.male);
        }else {
            clickMethod(page.female);
        }

        clickMethod(page.nations);
        Select select = new Select(page.nations);
        List<WebElement> options = select.getOptions();
        for(WebElement option: options){
            String optionText = option.getText();
            System.out.println(optionText);
        }
        select.selectByValue(nation);

        clickMethod(page.maritalStatus);
        Select select1 = new Select(page.maritalStatus);
        select1.selectByVisibleText(maritalStatus);

        sendText(page.doB, dateOfBirth);
    }


    @Then("user enters the employees {string}, {string}, and {string}")
    public void user_enters_the_employees_and(String nickName, String smoker, String militaryService) {
        EmployeePersonalDetailsPage page = new EmployeePersonalDetailsPage();
        sendText(page.nickName, nickName);

        if(smoker.equalsIgnoreCase("yes")) {
            clickMethod(page.smokerCheckbox);
        }
        sendText(page.military, militaryService);
    }








}
