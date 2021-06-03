package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class deleteEmployeeStepDefinitions {
    private Response response;
    JsonPath path;
    private int statusCode;

    @When("I requesting to delete employee with {int}")
    public void requestEmployee (int id) throws InterruptedException {
        RequestSpecification request = RestAssured.given();
        statusCode = 0;
        int attemptNum = 0;
        System.out.println("Deleting employee with id = " + id);
        while ((statusCode != 200) && (attemptNum < 3)) {
            response = request.delete("http://dummy.restapiexample.com/api/v1/delete/" + id);
            statusCode = response.getStatusCode();
            Thread.sleep(3000);
            attemptNum++;
        }
    }

    @Then("I receive {int} status code")
    public void receiveCode(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);}

    @And("I receive 'Successfully! Record has been deleted' in answer body")
    public void receiveAnswer() {
        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been deleted"));
    }
}
