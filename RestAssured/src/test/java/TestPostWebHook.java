import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

@RunWith(SerenityRunner.class)
public class TestPostWebHook {
    @Test
    public void postRequestExampleTest() {
        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());
        JSONObject requestBody = new JSONObject();
        requestBody.put("FirstName", someRandomString);
        requestBody.put("LastName", someRandomString);
        requestBody.put("UserName", someRandomString);
        requestBody.put("Password", someRandomString);
        requestBody.put("Email", "91e5785e-1966-48fe-b2f7-bbaa84387887@email.webhook.site");
        RequestSpecification request = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(requestBody.toString());
        Response response = request.post("https://webhook.site/91e5785e-1966-48fe-b2f7-bbaa84387887");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println("The status code recieved: " + statusCode);
    }
}
