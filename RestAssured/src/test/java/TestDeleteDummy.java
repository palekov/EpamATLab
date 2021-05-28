import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestDeleteDummy {
    @Test
    public void deleteTest() {
        int empid = 15410;
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        // Delete the request and check the response
        Response response = request.delete("/delete/"+ empid);
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been deleted"));

//        Assert.assertEquals(statusCode, 404);
//        jsonString =response.asString();
//        Assert.assertEquals(jsonString.contains("Record to delete not found"), true);
    }
}
