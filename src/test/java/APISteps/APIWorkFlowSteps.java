package APISteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIWorkFlowSteps {
    RequestSpecification  request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared for creating an employee")
    public void a_request_is_prepared_for_creating_an_employee() {

        request = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type)
                .header(APIConstants.Header_Authorization, GenerateTokenSteps.token)
                .body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a POST call is made for creating an employee")
    public void a_post_call_is_made_for_creating_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee created contains key {string} and value {string}")
    public void the_employee_created_contains_key_and_value(String message, String employeeCreatedValue) {
        response.then().assertThat().body(message, equalTo(employeeCreatedValue));
    }

    @Then("the employee id {string} is stored as a global variable to be used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empID) {
        employee_id = response.jsonPath().getString(empID);
        System.out.println(employee_id);
    }

    /*
    -----------------------------------------------------------------------------------------------------------------
     */

    @Given("a request is prepared to retrieve the created employee")
    public void a_request_is_prepared_to_retrieve_the_created_employee() {
        request = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type)
                .header(APIConstants.Header_Authorization, GenerateTokenSteps.token)
                .queryParam("employee_id", employee_id);
    }

    @When("a GET call is made to retrieve the created employee")
    public void a_get_call_is_made_to_retrieve_the_created_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code for for thus employee is {int}")
    public void the_status_code_for_for_thus_employee_is(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the retrieved employee ID {string} should match the globally stored employee id")
    public void the_retrieved_employee_id_should_match_the_globally_stored_employee_id(String employeeIDFromResponse) {
        String TempEmpID = response.jsonPath().getString(employeeIDFromResponse);
        Assert.assertEquals(employee_id, TempEmpID);
    }

    @Then("the retrieved data at {string} object matches the data used to create an employee with employee id {string}")
    public void the_retrieved_data_at_object_matches_the_data_used_to_create_an_employee_with_employee_id
            (String employeeObject, String responseEmployeeId, DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        Map<String, String> actualData = response.body().jsonPath().get(employeeObject);

        int index = 0;
        for (Map<String, String> map:expectedData) {
            Set<String> keys = map.keySet();
            for (String key:keys){
                String expectedValue = map.get(key);
                String actualValue = actualData.get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
            index++;
        }
        String empId = response.body().jsonPath().getString(responseEmployeeId);
        Assert.assertEquals(empId, employee_id);
    }

    @Given("a request is prepared for creating an employee with dynamic data {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void a_request_is_prepared_for_creating_an_employee_with_dynamic_data
            (String firstname, String lastname, String middleName,
             String gender, String empBirthday, String empStatus, String empJobTitle) {

        request = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type)
                .header(APIConstants.Header_Authorization, GenerateTokenSteps.token)
                .body(APIPayloadConstants.payloadMoreDynamic(firstname, lastname, middleName,
                        gender, empBirthday, empStatus, empJobTitle));
        System.out.println(request);

    }

}
