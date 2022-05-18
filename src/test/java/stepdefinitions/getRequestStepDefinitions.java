package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import apiconfigs.APIPaths;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPost;
import utilities.ConfigurationReader;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class getRequestStepDefinitions {
    Response response;
    JsonPlaceHolderPost jsonPlaceHolderPost;

    @Given("send get request using the api {string}")
    public void send_get_request_using_the_api(String base_URI) throws IOException {
        baseURI = ConfigurationReader.getProperty(base_URI);
        response = given().contentType("application/json")
                .when().get(APIPaths.GET_SPECIFIC_POST);
        ObjectMapper objectMapper = new ObjectMapper();
        jsonPlaceHolderPost = objectMapper.readValue(response.asString(),JsonPlaceHolderPost.class);
    }

    @Then("verify firstName {string}")
    public void verify_first_name(String id) {
        System.out.println(id);
        assertEquals(response.jsonPath().getInt("id"),Integer.parseInt(id));
    }
    @Then("verify lastName {string}")
    public void verify_last_name(String title) {
        System.out.println(title);
        assertEquals(response.jsonPath().get("title"),title);
    }


}
