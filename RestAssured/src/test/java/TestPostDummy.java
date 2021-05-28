import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestPostDummy {
    @Test
    public void postTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("age", 23);
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
       // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithoutNameTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("age", 23);
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
       // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithoutAgeTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithNullAgeTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("age", 0);
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithNegativeAgeTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("age", -1);
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithBigAgeTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("age", 120);
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithoutNameAndAgeTest() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("salary", 12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }

    @Test
    public void postWithNegativeSalary() {
        RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "test");
        requestParams.put("age", 23);
        requestParams.put("salary", -12000);
        request.body(requestParams.toString());
        Response response = request.post("/create");
        int statusCode = response.getStatusCode();
        // System.out.println(response.asString());
        Assert.assertEquals(200, statusCode);
        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("Successfully! Record has been added."));
    }
}
