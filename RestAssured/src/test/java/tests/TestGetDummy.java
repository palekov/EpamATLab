package tests;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestGetDummy {
    @Test
    public void getAllEmployeesTest() {
        RestAssured.
                when().get("http://dummy.restapiexample.com/employee").
                then().assertThat().statusCode(200);
    }

    @Test
    public void getEmployeeByIdTest() {
        int empid = 15410;
        RestAssured.
                when().get("http://dummy.restapiexample.com/employee" + "/" + empid).
                then().assertThat().statusCode(200);
    }
}