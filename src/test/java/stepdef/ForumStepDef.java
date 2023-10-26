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
    @Given("The right authentication")
    public void theRightAuthentication() {
        forumMentutorAPI.login("loginMentee.json");
    }

    @And("I have a valid authentication token and valid path {string}")
    public void iHaveValidAuthToken(String path) {
        forumMentutorAPI.accessForumWithAuthToken(path);
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
        forumMentutorAPI.login("loginMentee.json");
        forumMentutorAPI.accessForumWithAuthToken(path);
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
//CASE 4


    @Given("Post with forum with valid form data {string} as caption and {string} as images")
    public void postWithForumWithValidFormDataAsCaptionAndAsImages(String caption, String images) {
    File imageFile = new File(ConstantForum.IMAGES + images);
    forumMentutorAPI.postForum(imageFile, caption);
}

    @When("Send request post forum with valid form data")
    public void sendRequestPostForumWithValidFormData() {
        SerenityRest.when().post(forumMentutorAPI.POST_FORUM);
    }

    @Then("Status code forum should be {int} created")
    public void statusCodeForumShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
//CASE 5

    @And("Post with forum with no imagae form data {string} as caption and {string} as images")
    public void postWithForumWithNoImagaeFormDataAsCaption(String caption, String images) {
        File imageFile = new File(ConstantForum.IMAGES + images);
        forumMentutorAPI.postForum(imageFile, caption);
    }
}
