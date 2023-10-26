package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.MentorMentutorApi;
import starter.mentutor.ResponseMentorMentutor;
import starter.utils.ConstantMentor;

import java.io.File;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class MentorStepDef {
@Steps
MentorMentutorApi mentorMentutorApi;
String caption;
int score_int;
String score_str;
String title;
String id_str;
int id_int;
int id_status;
String name;
String email;
String password;
String images;
String description;
String attachment;
String due_date;
String file;
String id_status_str;
int id_submission_int;
String id_submission_str;
int id_task_int;
String id_task_str;





//----------GET ALL TASK BY ID MENTOR--------

//    Scenario 1: Get all task
    @Given("Get list task")
    public void getListTask() {
        mentorMentutorApi.login("MentorLogin.json");
    }

    @When("Send request mentor get all task")
    public void sendRequestMentorGetAllTask() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .get(MentorMentutorApi.GET_LIST_TASK);
    }

//    Scenario:Get all task with valid query param and invalid query param
    @Given("get list user query params title {string}")
    public void getListUserQueryParamsTitle(String title) {
        mentorMentutorApi.login("MentorLogin.json");
        this.title= title;

    }

    @When("Send request Get list task with param")
    public void sendRequestGetListTaskWithParam() {
        mentorMentutorApi.login("MentorLogin.json");
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("title", this.title)
                .get(MentorMentutorApi.GET_LIST_TASK_WITH_PARAM);

    }
    @When("Get all task with invalid query param")
    public void getAllTaskWithInvalidQueryParam() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("title", this.title)
                .get(MentorMentutorApi.GET_LIST_TASK_WITH_PARAM);
    }

//--------GET DETAIL TASK---------
//    Scenario 1:Get task detail with valid id

    @Given("get task with valid id {int}")
    public void getTaskWithValidId(int id) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_int=id;

    }

    @When("send request Get task detail with valid id")
    public void sendRequestGetTaskDetailWithValidId() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id",this.id_int)
                .get(MentorMentutorApi.GET_TASK_VALID_ID);
    }

//    Scenario2:Get task detail using special char on id
    @Given("Get task detail using special char on id {string}")
    public void getTaskDetailUsingSpecialCharOnId(String id) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_str=id;
    }

    @When("send request Get task detail using special char on id")
    public void sendRequestGetTaskDetailUsingSpecialCharOnId() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id",this.id_str)
                .get(MentorMentutorApi.GET_TASK_VALID_ID);
    }


//    Scenario 3:Get task detail with doesn't exist id
    @Given("Get task detail with doesn't exist id {int}")
    public void getTaskDetailWithDoesnTExistId(int id) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_int=id;
    }

    @When("send request Get task detail with doesn't exist id")
    public void sendRequestGetTaskDetailWithDoesnTExistId() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id",this.id_int)
                .get(MentorMentutorApi.GET_TASK_VALID_ID);
    }

//    Scenario 4:Get task detail using alphabeth on id

    @Given("Get task detail using alphabeth on id {string}")
    public void getTaskDetailUsingAlphabethOnId(String id) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_str=id;
    }

    @When("send request Get task detail using alphabeth on id")
    public void sendRequestGetTaskDetailUsingAlphabethOnId() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id",this.id_int)
                .get(MentorMentutorApi.GET_TASK_VALID_ID);
    }

//      ---------PUT UPDATE PROFILE MENTOR---------
//    Scenario 1:Put update profile mentor with valid name

    @Given("change body to name {string} email {string} password {string} images {string}")
    public void changeBodyToNameEmailPasswordImages(String name, String email, String password,String images) {
        mentorMentutorApi.login("MentorLogin.json");
        File imageFile = new File(ConstantMentor.IMAGES + images);
        mentorMentutorApi.putUpdateProfile(name,email,password,imageFile);
        this.name=name;
        this.email=email;
        this.password=password;
        this.images=images;
    }


    @When("Send request mentor update profile user")
    public void sendRequestMentorUpdateProfileUser() {
        File imageFile = new File(ConstantMentor.IMAGES + this.images);
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .contentType("multipart/form-data")
                .multiPart("name", this.name)
                .multiPart("email", this.email)
                .multiPart("password",password)
                .multiPart("images", imageFile)
                .put(MentorMentutorApi.UPDATE_PROFILE_MENTOR);
    }
    @Then("response code mentor should be {int}")
    public void responseCodeMentorShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Responses body should be {string}")
    public void responsesBodyShouldBe(String message) {
        SerenityRest.then()
                .body(ResponseMentorMentutor.MESSAGE, equalTo(message));
    }

    @And("Validate JSON Schema {string}")
    public void validateJSONSchema(String schemaFile) {
        File json = new File(ConstantMentor.JSON_SCHEMA+schemaFile);
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Responses body message error should be {string}")
    public void responsesBodyMessageErrorShouldBe(String message_error) {

    }

    @When("Send request mentor update profile user without input name,email,password")
    public void sendRequestMentorUpdateProfileUserWithoutInputNameEmailPassword() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .put(MentorMentutorApi.UPDATE_PROFILE_MENTOR);
    }

//      ---------PUT UPDATE TASK BY MENTOR---------

    @Given("change id {int} and body to title {string} description {string} due date {string} attachment {string} images {string}")
    public void changeBodyToTitleDescriptionDueDateAttachmentImages(int id,String title, String description, String due_date, String attachment, String images) {
        mentorMentutorApi.login("MentorLogin.json");
        File imageFile = new File(ConstantMentor.IMAGES + images);
        File docsFile = new File(ConstantMentor.DOCS + attachment);
        mentorMentutorApi.putUpdateTask(id,title,description,due_date,docsFile,imageFile);
        this.id_int=id;
        this.title=title;
        this.description=description;
        this.due_date=due_date;
        this.attachment=attachment;
        this.images=images;
    }

    @When("Send request mentor update task")
    public void sendRequestMentorUpdateTask() {
        File docsFile = new File(ConstantMentor.DOCS + this.attachment);
        File imageFile = new File(ConstantMentor.IMAGES + this.images);
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id",this.id_int)
                .contentType("multipart/form-data")
                .multiPart("title", this.title)
                .multiPart("description", this.description)
                .multiPart("due_date",due_date)
                .multiPart("attachment", docsFile)
                .multiPart("images", imageFile)
                .put(MentorMentutorApi.PUT_UPDATE_TASK);
    }

    @Given("change id {string} and body to title {string} description {string} due date {string} attachment {string} images {string}")
    public void changeIdAndBodyToTitleDescriptionDueDateAttachmentImages(String id,String title, String description, String due_date, String attachment, String images) {
        mentorMentutorApi.login("MentorLogin.json");
        File imageFile = new File(ConstantMentor.IMAGES + images);
        File docsFile = new File(ConstantMentor.DOCS + attachment);
        mentorMentutorApi.putUpdateTaskInvalidId(id,title,description,due_date,docsFile,imageFile);
        this.id_str=id;
        this.title=title;
        this.description=description;
        this.due_date=due_date;
        this.attachment=attachment;
        this.images=images;
    }
//      ---------POST ADD TASK BY MENTOR---------

    @Given("change body to title {string} description {string} due date {string} file {string} images {string}")
    public void changeBodyToTitleDescriptionDueDateAttachmentImages(String title, String description, String due_date, String file, String images) {
        mentorMentutorApi.login("MentorLogin.json");
        File imageFile = new File(ConstantMentor.IMAGES + images);
        File docsFile = new File(ConstantMentor.DOCS + file);
        mentorMentutorApi.addTaskByMentor(title,description,due_date,docsFile,imageFile);
        this.title=title;
        this.description=description;
        this.due_date=due_date;
        this.file=file;
        this.images=images;
    }

    @When("Send request mentor post task")
    public void sendRequestMentorPostTask() {
        File docsFile = new File(ConstantMentor.DOCS + this.file);
        File imageFile = new File(ConstantMentor.IMAGES + this.images);
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .contentType("multipart/form-data")
                .multiPart("title", this.title)
                .multiPart("description", this.description)
                .multiPart("due_date",due_date)
                .multiPart("file", docsFile)
                .multiPart("images", imageFile)
                .post(MentorMentutorApi.POST_ADD_TASK);
    }

    @When("Send request mentor post task without input title,describtion,due date,attachment,Images")
    public void sendRequestMentorPostTaskWithoutInputTitleDescribtionDueDateAttachmentImages() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .post(MentorMentutorApi.POST_ADD_TASK);
    }

    @When("Send request mentor post task without input attachment")
    public void sendRequestMentorPostTaskWithoutInputAttachment() {
        File imageFile = new File(ConstantMentor.IMAGES + this.images);
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .contentType("multipart/form-data")
                .multiPart("title", this.title)
                .multiPart("description", this.description)
                .multiPart("due_date",due_date)
                .multiPart("images", imageFile)
                .post(MentorMentutorApi.POST_ADD_TASK);
    }

    @When("Send request mentor post task without input due date")
    public void sendRequestMentorPostTaskWithoutInputDueDate() {
        File docsFile = new File(ConstantMentor.DOCS + this.file);
        File imageFile = new File(ConstantMentor.IMAGES + this.images);
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .contentType("multipart/form-data")
                .multiPart("title", this.title)
                .multiPart("description", this.description)
                .multiPart("file", docsFile)
                .multiPart("images", imageFile)
                .post(MentorMentutorApi.POST_ADD_TASK);
    }
//      --------- POST ADD COMMENTS ON STATUS---------

    @Given("Post with id {int} and valid caption {string}")
    public void postWithValidIdAndValidComment(int id_status, String caption) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_status= id_status;
        this.caption=caption;
    }

    @When("Send request Post with valid id and valid comment")
    public void sendRequestPostWithValidIdAndValidComment() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id status",this.id_status)
                .contentType("multipart/form-data")
                .multiPart("caption", this.caption)
                .post(MentorMentutorApi.POST_ADD_COMMENT);
    }

    @When("send request post with valid id without input comment")
    public void sendRequestPostWithValidIdWithoutInputComment() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id status",this.id_status)
                .contentType("multipart/form-data")
                .post(MentorMentutorApi.POST_ADD_COMMENT);
    }


    @Given("Post with id {string} and valid caption {string}")
    public void postWithIdAndValidCaption(String id_status_str, String caption) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_status_str= id_status_str;
        this.caption=caption;
    }

//  -----------POST SUBMIT SCORE BY MENTOR----------
    @Given("Post submission with id submission {int} id task {int} and score {int}")
    public void postSubmissionWithIdSubmissionIdTaskAndValidScore(int id_submission, int id_task, int score) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_submission_int=id_submission;
        this.id_task_int=id_task;
        this.score_int=score;
    }

    @When("Send request Post submission")
    public void sendRequestPostSubmission() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id_submission",this.id_submission_int)
                .contentType("multipart/form-data")
                .multiPart("id_task", this.id_task_int)
                .multiPart("score", this.score_int)
                .post(MentorMentutorApi.POST_SUBMIT_SCORE);
    }
    @Given("Post submission with id submission {int} id task {string} and score {int}")
    public void postSubmissionWithIdSubmissionIdTaskAndScore(int id_submission, String id_task, int score) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_submission_int=id_submission;
        this.id_task_str=id_task;
        this.score_int=score;
    }

    @Given("Post submission with id submission {string} id task {int} and score {int}")
    public void postSubmissionWithIdSubmissionIdTaskAndScore(String id_submission, int id_task, int score) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_submission_str=id_submission;
        this.id_task_int=id_task;
        this.score_int=score;
    }

    @Given("Post submission with id submission {int} id task {int} and score {string}")
    public void postSubmissionWithIdSubmissionIdTaskAndScore(int id_submission, int id_task, String score) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_submission_int=id_submission;
        this.id_task_int=id_task;
        this.score_str=score;
    }
// -----------DELETE TASK BY MENTOR----------

    @Given("Delete task with id {int}")
    public void deleteTaskWithValidId(int id_task) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_task_int=id_task;
    }

    @When("Send request delete task")
    public void sendRequestDeleteTask() {
        SerenityRest.given()
                .header("Authorization", "Bearer "+mentorMentutorApi.getToken())
                .pathParam("id_task",this.id_task_int)
                .delete(MentorMentutorApi.DELETE_TASK);
    }

    @Given("Delete task with id {string}")
    public void deleteTaskWithId(String id_task) {
        mentorMentutorApi.login("MentorLogin.json");
        this.id_task_str=id_task;
    }
}
