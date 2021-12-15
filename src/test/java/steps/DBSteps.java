package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DBSteps {

    @Then("query database and get data")
    public void query_database_and_get_data() {
        GlobalVariables.mapDataFromDB = DBUtils.mapFromDb("SELECT emp_firstname, emp_middle_name, emp_lastname " +
                "FROM hs_hr_employees " +
                "WHERE employee_id="+ GlobalVariables.empId);
    }

    @Then("verify employee data is in DB")
    public void verifyEmployeeDataIsInDB() {
        String actual = DBUtils.mapFromDb("select * from ohrm_user where user_name='" + GlobalVariables.userName + "';").get("user_name");
        String expected=GlobalVariables.userName;
        System.out.println("Actual "+actual);
        System.out.println("Expected "+expected);
        Assert.assertEquals(actual, expected);
    }
}
