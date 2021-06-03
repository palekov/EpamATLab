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

public class getAllEmployeesStepDefinitions {
    private Response response;
    JsonPath path;
    private int statusCode;

    @When("^I requesting all existing employees$")
    public void getAllEmployees() throws InterruptedException {
        RequestSpecification request = RestAssured.given();
        statusCode = 0;
        int attemptNum = 0;
        while ((statusCode != 200) && (attemptNum < 3)) {
            response = request.get("http://dummy.restapiexample.com/api/v1/employees");
            statusCode = response.getStatusCode();
            Thread.sleep(3000);
            attemptNum++;
        }
    }

    @Then("^I receive response (\\d+) OK code$")
    public void receiveResponse(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("^the number of employees received")
    public void receiveNumberOfEmployees() {
        path = response.jsonPath();
        List<HashMap<String, Object>> data = path.getList("data");
        int  employeesNum = data.size();
        System.out.println("Number of employees received: " + employeesNum);
    }
}
