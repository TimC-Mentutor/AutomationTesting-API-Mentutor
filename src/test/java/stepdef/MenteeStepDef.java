package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.MenteeMentutorAPI;
import starter.mentutor.ResponseMenteeMentutor;
import starter.utils.ConstantMentee;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class MenteeStepDef {

    @Steps
    MenteeMentutorAPI menteeMentutorAPI;


//CASE 1
    @Given("Get all task as mentee with valid path {string}")
    public void getAllTaskAsMenteeWithValidPath(String path) {
        menteeMentutorAPI.login("loginMentee.json");
        menteeMentutorAPI.getAllTask(path);
    }

    @When("Send request get all task as mentee with valid path")
    public void sendRequestGetAllTaskAsMenteeWithValidPath() {
        SerenityRest.when().get(menteeMentutorAPI.GET_ALL_TASK);
    }

    @Then("Status code Mentee should be {int} ok")
    public void statusCodeMenteeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("the response body title should be {string}")
    public void theResponseBodyTitleShouldBe(String title) {
        SerenityRest.and()
                .body(ResponseMenteeMentutor.TITLE,equalTo(title));
    }

//CASE 2
    @Given("Get all task as mentee with invalid path {string}")
    public void getAllTaskAsMenteeWithInvalidPath(String path) {
        menteeMentutorAPI.login("loginMentee.json");
        menteeMentutorAPI.getAllTask(path);
    }

    @When("Send request get all task as mentee with invalid path")
    public void sendRequestGetAllTaskAsMenteeWithInvalidPath() {
        SerenityRest.when().get(menteeMentutorAPI.GET_ALL_TASK);
    }

    @Then("Status code mentee should be {int} not found")
    public void statusCodeMenteeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("there should be an error message for invalid path {string}")
    public void thereShouldBeAnErrorMessageForInvalidPath(String message) {
        SerenityRest.and()
                .body(ResponseMenteeMentutor.MESSAGE,equalTo(message));
    }

//CASE 3
    @When("Send request get all task as mentee with wrong method")
    public void sendRequestGetAllTaskAsMenteeWithWrongMethod() {
        SerenityRest.when().post(menteeMentutorAPI.GET_ALL_TASK);
    }

    @Then("Status code Mentee should be {int} method not allowed")
    public void statusCodeMenteeShouldBeMethodNotAllowed(int notAllowed) {
        SerenityRest.then().statusCode(notAllowed);
    }

    @And("there should be an error message for wrong method {string}")
    public void thereShouldBeAnErrorMessageForWrongMethod(String message) {
            SerenityRest.and()
                    .body(ResponseMenteeMentutor.MESSAGE,equalTo(message));
    }
//CASE 4
    @Given("Post task with valid file {string} and valid id task {int}")
    public void postTaskWithValidFileAndValidIdTask(String pdf, int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File filePdf = new File(ConstantMentee.DOCS + pdf);
        menteeMentutorAPI.postTask(path, filePdf);
    }

    @When("Send request post task with valid file and id")
    public void sendRequestPostTaskWithValidFileAndId() {
        SerenityRest.when().post(menteeMentutorAPI.POST_TASK);
    }

    @Then("Status code Mentee Should be {int} created")
    public void statusCodeMenteeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("There should be a message saying {string}")
    public void thereShouldBeAMessageSaying(String message) {
        SerenityRest.and()
                .body(ResponseMenteeMentutor.MESSAGE,equalTo(message));
    }
//CASE 5
    @Given("Post task with empty file and invalid id task {int}")
    public void postTaskWithEmptyFileAndInvalidIdTask(int path) {
        menteeMentutorAPI.login("loginMentee.json");
        menteeMentutorAPI.postTaskWithEmptyFile(path);
    }

    @When("Send request post task with empty file and invalid id task")
    public void sendRequestPostTaskWithEmptyFileAndInvalidIdTask() {
        SerenityRest.when().post(menteeMentutorAPI.POST_TASK);
    }

//CASE 6

    @Given("Post task with valid file {string} and invalid id task {int}")
    public void postTaskWithValidFileAndInvalidIdTask(String pdf, int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File filePdf = new File(ConstantMentee.DOCS + pdf);
        menteeMentutorAPI.postTask(path, filePdf);
    }

    @When("Send request post task with valid file and invalid id task")
    public void sendRequestPostTaskWithValidFileAndInvalidIdTask() {
        SerenityRest.when().post(menteeMentutorAPI.POST_TASK);
    }
//CASE 7
    @Given("post with wrong format file {string} and valid id tasks {int}")
    public void postWithWrongFormatFileAndValidIdTasks(String images, int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File fileImage = new File(ConstantMentee.IMAGES + images);
        menteeMentutorAPI.postTask(path, fileImage);
    }

    @When("Send request post task with wrong format and valid id task")
    public void sendRequestPostTaskWithWrongFormatAndValidIdTask() {
        SerenityRest.when().post(menteeMentutorAPI.POST_TASK);
    }

    @Then("Status code mentee should be {int} bad request")
    public void statusCodeMenteeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
//CASE 8
    @Given("post with empty file and valid id tasks {int}")
    public void postWithEmptyFileAndValidIdTasks(int path) {
        menteeMentutorAPI.login("loginMentee.json");
        menteeMentutorAPI.postTaskWithEmptyFile(path);
    }

    @When("Send request post with empty file and valid id tasks")
    public void sendRequestPostWithEmptyFileAndValidIdTasks() {
        SerenityRest.when().post(menteeMentutorAPI.POST_TASK);
    }
//CASE 9
    @Given("Post comment with valid json {string} and valid id status {int}")
    public void postCommentWithValidJsonAndValidIdStatus(String jsonFile, int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File json = new File(ConstantMentee.REQ_BODY + jsonFile);
        menteeMentutorAPI.postComment(path, json);
    }

    @When("Send request post comment with valid json")
    public void sendRequestPostCommentWithValidJson() {
        SerenityRest.when().post(menteeMentutorAPI.POST_COMMENT);
    }
//CASE 10
    @Given("Post comment with valid multiform {string} multi form and valid id status {int}")
    public void postCommentWithMultiFormAndValidIdStatus(String caption,int path) {
        menteeMentutorAPI.login("loginMentee.json");
        menteeMentutorAPI.postCommentWithForm(path, caption);
    }

    @When("Send request post commment with multi form")
    public void sendRequestPostCommmentWithMultiForm() {
        SerenityRest.when().post(menteeMentutorAPI.POST_COMMENT);
    }
//CASE 11
    @Given("Post comment with valid json {string} and invalid id status {string}")
    public void postCommentWithValidJsonAndInvalidIdStatus(String jsonFile, String path) {
        menteeMentutorAPI.login("loginMentee.json");
        File json = new File(ConstantMentee.REQ_BODY + jsonFile);
        menteeMentutorAPI.postComment(path, json);
    }

    @When("Send request post comment with valid json and invalid id status")
    public void sendRequestPostCommentWithValidJsonAndInvalidIdStatus() {
        SerenityRest.when().post(menteeMentutorAPI.POST_COMMENT);
    }
//CASE 12
    @Given("Post comment with empty data on json {string} and valid id status {int}")
    public void postCommentWithEmptyDataOnJsonAndValidIdStatus(String jsonFile, int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File json = new File(ConstantMentee.REQ_BODY + jsonFile);
        menteeMentutorAPI.postComment(path, json);
    }
    @When("Send request post comment with empty data and valid id status")
    public void sendRequestPostCommentWithEmptyDataAndValidIdStatus() {
        SerenityRest.when().post(menteeMentutorAPI.POST_COMMENT);
    }

    @And("validate jsonSchema on post comment with empty data {string}")
    public void validateJsonSchemaOnPostCommentWithEmptyData(String jsonFile) {
        File json = new File(ConstantMentee.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//CASE 13
    @Given("post comment with less than five characters on json {string} and valid id status {int}")
    public void postCommentWithLessThanFiveCharactersOnJsonAndValidIdStatus(String jsonFile,int path) {
        menteeMentutorAPI.login("loginMentee.json");
        File json = new File(ConstantMentee.REQ_BODY + jsonFile);
        menteeMentutorAPI.postComment(path, json);
    }

    @When("Send request post comment with less than five characters and valid id status")
    public void sendRequestPostCommentWithLessThanFiveCharactersAndValidIdStatus() {
        SerenityRest.when().post(menteeMentutorAPI.POST_COMMENT);
    }

    @And("validate jsonSchema on post comment with less than five characters {string}")
    public void validateJsonSchemaOnPostCommentWithLessThanFiveCharacters(String jsonFile) {
        File json = new File(ConstantMentee.JSON_SCHEMA + jsonFile);
        SerenityRest.and()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//CASE 14
    @Given("Put update user with valid data and param on {string} as name and {string} as email and {string} as password and {string} as images file")
    public void putUpdateUserWithValidDataAndParamOnAsNameAndAsEmailAndAsPasswordAndAsImagesFile
    (String name, String email, String password, String imagesFile) {
        menteeMentutorAPI.login("loginMentee.json");
        File images = new File(ConstantMentee.IMAGES + imagesFile);
        menteeMentutorAPI.putUpdateWithForm(name,email,password,images);
    }

    @When("send request put update user with valid data and param")
    public void sendRequestPutUpdateUserWithValidDataAndParam() {
        SerenityRest.when().put(menteeMentutorAPI.PUT_UPDATE);
    }
//CASE 15
    @Given("Put update user with {string} json file as body instead with form-data")
    public void putUpdateUserWithJsonFileAsBodyInsteadWithFormData(String arg0) {
        menteeMentutorAPI.login("loginMentee.json");
        File json = new File(ConstantMentee.REQ_BODY + arg0);
        menteeMentutorAPI.putUpdateWithJson(json);
    }

    @When("Send request put user with json file as body instead with form-data")
    public void sendRequestPutUserWithJsonFileAsBodyInsteadWithFormData() {
        SerenityRest.when().put(menteeMentutorAPI.PUT_UPDATE);
    }


//    @Given("{string} as name and {string} as email and {string} and {string} as images")
//    public void asNameAndAsEmailAndAndAsImages(String name, String email, String password, String imagesFile) {
//            menteeMentutorAPI.login("loginMentee.json");
//            File images = new File(ConstantMentee.IMAGES + imagesFile);
//            menteeMentutorAPI.putUpdateWithForm(name,email,password,images);
//    }
//
//    @When("send request put update user with wrong images format data and valid param")
//    public void sendRequestPutUpdateUserWithWrongImagesFormatDataAndValidParam() {
//            SerenityRest.when().put(menteeMentutorAPI.PUT_UPDATE);
//    }





}
