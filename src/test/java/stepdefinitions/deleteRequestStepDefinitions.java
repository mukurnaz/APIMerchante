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

public class deleteRequestStepDefinitions {
    JsonPlaceHolderPost jsonPlaceHolderPost = new JsonPlaceHolderPost();
    Response response;
    @Given("send delete request using the api {string}")
    public void sendDeleteRequestUsingTheApi(String base_URI) {
        baseURI = ConfigurationReader.getProperty(base_URI);
        response = given().headers(HeaderConfig.defaultHeaders())
                .when().delete(APIPaths.DELETE_POST);
    }

    @Then("verify statusCode for delete {string}")
    public void verifyStatusCodeForDelete(String statusCode) {
        response.then().assertThat().statusCode(Integer.parseInt(statusCode));
    }
}
