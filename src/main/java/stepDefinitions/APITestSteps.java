package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Optional;

public class APITestSteps {


    //RestAssured
   String mainURL = "https://reqres.in/api";
    RequestSpecification request = RestAssured.given();
    Response res;


//    RequestSpecification request = RestAssured.given();

//    Response res= request.get("/users/100");

//        System.out.println(res.getStatusCode());



    @Given("I have valid URL")
    public void i_have_valid_url() {
        // Write code here that turns the phrase above into concrete actions
//        RestAssured.baseURI = mainURL;

    }
    @When("I send the request using GET for user {string}")
    public void i_send_the_request_using_get(String userID) {


        RestAssured.baseURI = "https://reqres.in/api";

        RequestSpecification request = RestAssured.given();

        res= request.get("/users/"+ userID);

    }
    @Then("i should get {string}")
    public void i_should_get(String statusCode) {

        String expected_status_code = statusCode;
        Integer actual_StatusCode = res.getStatusCode();

        Assert.assertEquals(actual_StatusCode.toString(), expected_status_code.toString(), "Response does not return 200.");

        System.out.println(res.getBody().toString());

    }

}
