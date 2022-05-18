package stepdefinitions;

import apiconfigs.APIPaths;
import apiconfigs.HeaderConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPost;
import utilities.ConfigurationReader;

import static org.testng.Assert.*;
import static io.restassured.RestAssured.given;

public class postRequestStepDefinition {
    JsonPlaceHolderPost jsonPlaceHolderPost = new JsonPlaceHolderPost();
    Response response;


    @Given("send post request using the api {string}")
    public void sendPostRequestUsingTheApi(String arg0) {
        RestAssured.baseURI = ConfigurationReader.getProperty("base_URI");
        jsonPlaceHolderPost.setBody("muaz body");
        jsonPlaceHolderPost.setId(1);
        jsonPlaceHolderPost.setUserId(101);
        jsonPlaceHolderPost.setTitle("muaz title");
        response = given().headers(HeaderConfig.defaultHeaders())
                .when().body(jsonPlaceHolderPost).post(APIPaths.POST_POST);
    }


    @Then("verify statusCode {string}")
    public void verifyStatusCode(String statusCode) {
        assertEquals(response.getStatusCode(),Integer.parseInt(statusCode));
    }


    @And("verify id number {string}")
    public void verifyIdNumber(String id) {
        assertEquals(response.jsonPath().getInt("id"),Integer.parseInt(id));
    }
}
