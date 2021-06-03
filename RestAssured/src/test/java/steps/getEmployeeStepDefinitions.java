package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class getEmployeeStepDefinitions {
    private Response response;
    JsonPath path;
    private int statusCode;

    @When("^I requesting all existing employees$")
    public void getAllEmployees() {
        RequestSpecification request = RestAssured.given();
        response = request.get("http://dummy.restapiexample.com/api/v1/employees");
        statusCode = response.getStatusCode();
    }

    @Then("^I receive response (\\d+) OK code$")
    public void receiveResponse(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("the number of employees received must be more than one")
    public void checkNumberOfEmployees() {
        path = response.jsonPath();
        List<HashMap<String, Object>> data = path.getList("data");
        int  employeesNum = data.size();
        System.out.println("Number of employees received: " + employeesNum);
        Assert.assertTrue(employeesNum > 1 );
    }
}
