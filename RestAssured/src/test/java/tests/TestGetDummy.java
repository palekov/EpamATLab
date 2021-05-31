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
                when().get("http://dummy.restapiexample.com/employees").
                then().assertThat().statusCode(200);

//                when().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").
//                then().assertThat().statusCode(200).
//                and().body("args.foo2", is("bar2"));
    }

    @Test
    public void getEmployeeByIdTest() {
        int empid = 15410;
        RestAssured.
                when().get("http://dummy.restapiexample.com/employee" + "/" + empid).
                then().assertThat().statusCode(200);
    }
}