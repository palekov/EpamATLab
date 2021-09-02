package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class getOneEmployeeStepDefinitions {
    private Response response;
    JsonPath path;
    private int statusCode;

    @When("I requesting employee with {int}")
    public void requestEmployee (int id) throws InterruptedException {
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
    }

    @Then("I receive {int} code")
    public void receiveCode(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }
}
