package InterviewQnAPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITest {


//    public static void main(String[] args) {
//        System.out.println("API Test");
//
//        get_request_test();
//    }

    @BeforeTest()
    public void testcmmmon(){
        RestAssured.baseURI = "https://reqres.in/api";
    }


    @Test
    public  void get_request_single_user_200_test(){

        //RestAssured

        RestAssured.baseURI = "https://reqres.in/api";

        RequestSpecification request = RestAssured.given();

        Response res= request.get("/users/1");

        System.out.println(res.getStatusCode());

        Assert.assertEquals(res.getStatusCode(), 200, "Response does not return 200.");

    }

    @Test
    public  void get_request_invalid_user_401_test(){

        //RestAssured

        RequestSpecification request = RestAssured.given();

        Response res= request.get("/users/100");

        System.out.println(res.getStatusCode());

        Assert.assertEquals(res.getStatusCode(), 404, "Response does not return 200.");

    }


}
