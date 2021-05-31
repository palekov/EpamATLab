package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

public class StepDefinitions {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private int statusCode;

    @When("I create an employee {string} with age {string} and salary {string}")
    public void createAnEmployee(String name, String age, String salary) {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("age", age);
        requestParams.put("salary", salary);
        request.body(requestParams.toString());
        response = request.post("/create");
    }

    @Then("^I should receive response (\\d+) OK code$")
    public void receiveResponse(int expectedCode) {
        statusCode = response.getStatusCode();
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("created employee has name {string} and age {string} and salary {string}")
    public void createdEmployee(String name, String age, String salary) {
    }
}
