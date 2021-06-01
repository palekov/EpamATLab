package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class StepDefinitions {
    private Response response;
    private ValidatableResponse json;
    JSONArray jsonResponse;
    private RequestSpecification request;
    private int statusCode;

    @When("I create an employee {string} with age {string} and salary {string}")
    public void createAnEmployee(String name, String age, String salary) throws InterruptedException {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);
        requestParams.put("age", age);
        requestParams.put("salary", salary);
        request.body(requestParams.toString());
        statusCode = 0;
        int attemptNum = 0;

        while ((statusCode != 200) && (attemptNum < 3 )) {
            response = request.post("/create");
            statusCode = response.getStatusCode();
            Thread.sleep(3000);
            attemptNum++;
        }
        //jsonResponse = new JSONArray(response.asString());
    }

    @Then("^I should receive response (\\d+) OK code$")
    public void receiveResponse(int expectedCode) {

        //  System.out.println(response.asString());
        //  {"status":"success","data":{"id":6756},"message":"Successfully! Record has been added."}
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("created employee has some id number")
    public void createdEmployee() {
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("id"));
    }

}
