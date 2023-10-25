package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.ForumMentutorAPI;
import starter.mentutor.ResponseForumMentutor;
import starter.utils.ConstantForum;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ForumStepDef {

    @Steps
    ForumMentutorAPI forumMentutorAPI;

//CASE 1
    @Given("I have a valid authentication token and valid path {string}")
    public void iHaveValidAuthToken(String path) {
        String authToken = ConstantForum.AUTH_TOKEN;
        forumMentutorAPI.accessForumWithAuthToken(authToken,path);

    }

    @When("Send request get forum with valid path")
    public void sendRequestForumWithValidPath() {
        SerenityRest.when().get(forumMentutorAPI.GET_ALL_STATUS);
    }

    @Then("Status code forum should be {int} ok")
    public void statusCodeForumShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }


    @And("Response body name should be {string}")
    public void responseBodyNameShouldBe(String name) {
        SerenityRest.and()
                .body(ResponseForumMentutor.NAME,equalTo(name));
    }
//CASE 2
    @Given("I have a valid authentication token and invalid path {string}")
    public void iHaveAValidAuthenticationTokenAndInvalidPath(String path) {
        String authToken = ConstantForum.AUTH_TOKEN;
        forumMentutorAPI.accessForumWithAuthToken(authToken,path);
    }

    @When("Send request get forum with invalid path")
    public void sendRequestForumWithInvalidPath() {
        SerenityRest.when().get(forumMentutorAPI.GET_ALL_STATUS);
    }

    @Then("Status code forum should be {int} not found")
    public void statusCodeForumShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Jsonschema should be like {string}")
    public void jsonschemaShouldBeLike(String jsonFile) {
        File json = new File(ConstantForum.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//CASE 3
    @When("Send request get forum with wrong method")
    public void sendRequestGetForumWithWrongMethod() {
        SerenityRest.when().patch(forumMentutorAPI.GET_ALL_STATUS);
    }

    @Then("Status code forum should be {int} method is not allowed")
    public void statusCodeForumShouldBeMethodIsNotAllowed(int notAllowed) {
        SerenityRest.then().statusCode(notAllowed);
    }
}
