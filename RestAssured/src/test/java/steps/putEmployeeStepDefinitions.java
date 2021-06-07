package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

public class putEmployeeStepDefinitions {
    private Response response;
    private ValidatableResponse json;
    private int statusCode;
    private int employeeId;

    @Given("I get employee with {int}")
    public void getEmployee(int id) throws InterruptedException {
        RequestSpecification request = RestAssured.given();
        statusCode = 0;
        int attemptNum = 0;
        while ((statusCode != 200) && (attemptNum < 3)) {
            response = request.get("http://dummy.restapiexample.com/api/v1/employee/" + id);
            System.out.println("Requesting employee with id = " + id);
            statusCode = response.getStatusCode();
            Thread.sleep(3000);
            attemptNum++;
        }
        System.out.println(response);
        employeeId = id;
    }

    @When("I update an employee with {string}, {string} and {string}")
    public void updateEmployee(String age, String name, String salary) {
            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("age", age);
        requestParams.put("salary", salary);
        request.body(requestParams.toString());
        Response response = request.put("/update/" + employeeId);
        int statusCode = response.getStatusCode();
        System.out.println(response);
    }

    @Then("I should receive response code {int}")
    public void responseCode(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("updated employee has some {string}, {string} and {string}")
    public void getUpdatedEmployee(String age, String name, String salary) throws InterruptedException {

        getEmployee(employeeId);
        JsonPath path = response.jsonPath();

        String employeeName = path.get("data.employee_name");
        Integer employeeAge = path.get("data.age");
        Integer employeeSalary = path.get("data.employee_salary");

        Assert.assertEquals(name, employeeName);
        Assert.assertEquals(age, employeeAge.toString());
        Assert.assertEquals(salary, employeeSalary.toString());
    }
}

