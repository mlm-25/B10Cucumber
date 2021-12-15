package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamplesOfAPI {

    /*
Given - precondition - prepare the request
When - actions - sending the request/hitting the endpoint
Then - result - verify response
     */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE2MzkzMjUyNTgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzOTM2ODQ1OCwidXNlcklkIjoiMzIzMyJ9." +
            "6aEznyqrhG__3eQSUpgzlsSFSJOLSbk26aUNkIN1Lro";
    static String employee_id;

    @Test
    public void dGetDetailsOfOneEmployee(){
        // rest assured consider baseURL as baseURI

        //given
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", "25656A");

        //when - hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        //then - result/assertion
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void aCreateEmployee(){

        //given
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"emp_firstname\": \"first\",\n" +
                        "  \"emp_lastname\": \"last\",\n" +
                        "  \"emp_middle_name\": \"middle\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1999-01-12\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"API Tester\"\n" +
                        "}");

        //when
        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();
        // this pretty print does the same job as syso. // System.out.println(response.asString());

        // jsonPath() we use this to get specific information from the json object
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        //then
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_firstname", equalTo("first"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bGetCreatedEmployee(){

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        String empID = response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpId = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpId);

        String firstname = response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstname.contentEquals("first"));

        String lastname = response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastname.contentEquals("last"));
    }

    @Test
    public void cUpdatedCreatedEmployee(){

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n"+
                        "  \"emp_firstname\": \"Karim\",\n" +
                        "  \"emp_lastname\": \"Mostaf\",\n" +
                        "  \"emp_middle_name\": \"Benzema\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1999-01-12\",\n" +
                        "  \"emp_status\": \"Emp\",\n" +
                        "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();


    }

    @Test
    public void getAllEmployees(){

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json");

        Response response = preparedRequest.when().get("/getAllEmployees.php");

        String allEmployees = response.prettyPrint();

        JsonPath js = new JsonPath(allEmployees);

        int count = js.getInt("Employees.size()");
        System.out.println(count);

        for (int i = 0; i < count; i++) {

            String employeeIDs = js.getString("Employees[" + i + "].employee_id");
            System.out.println(employeeIDs);

        }
    }


}
