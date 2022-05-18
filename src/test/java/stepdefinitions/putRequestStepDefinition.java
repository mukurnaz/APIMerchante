package stepdefinitions;

import apiconfigs.APIPaths;
import apiconfigs.HeaderConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojo.JsonPlaceHolderPost;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class putRequestStepDefinition {
    JsonPlaceHolderPost jsonPlaceHolderPost= new JsonPlaceHolderPost();
    Response response;
    @Given("send put request using the api {string}")
    public void sendPutRequestUsingTheApi(String base_URI) {
        baseURI = ConfigurationReader.getProperty(base_URI);
        jsonPlaceHolderPost.setTitle("title muaz");
        jsonPlaceHolderPost.setBody("body muaz");
        jsonPlaceHolderPost.setId(22333);
        jsonPlaceHolderPost.setUserId(33322);
        response = given().headers(HeaderConfig.defaultHeaders())
                .when().body(jsonPlaceHolderPost).put(APIPaths.PUT_POST);
    }
    @Then("verify statusCode for put {string}")
    public void verifyStatusCodeFor(String statusCode) {
        response.then().assertThat().statusCode(Integer.parseInt(statusCode));
    }
}
