package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.AdminMentutorAPI;
import starter.mentutor.ResponsesAdminMentutor;
import starter.utils.ConstantAdmin;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class AdminStepDef {
    @Steps
    AdminMentutorAPI adminMentutorAPI;

    //POST RegisterUser positive-case
    @Given("Post register new user with valid request body {string}")
    public void postRegisterNewUserWithValidRequestBody(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }
    @When("Send post register new user")
    public void sendPostRegisterNewUser() {
        SerenityRest.when().post(ConstantAdmin.REGISTER_NEW_USER);
    }
    @Then("Response code admin should be {int} Created")
    public void shouldResponseCodeAdminShouldBeCreated(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
    @And("Register new user response body contain {string}")
    public void registerNewUserResponseBodyContain(String name) {
        SerenityRest.and().body(ResponsesAdminMentutor.NAME, equalTo(name));
    }
    @And("Validate register new user JSON schema {string}")
    public void validateRegisterNewUserJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //POST RegisterUser positive-case
    @Given("Post register new user with name value more than five characters {string}")
    public void postRegisterNewClassWithNameValueMore(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUserWithNameValueMoreThanChar(json);
    }

    //POST RegisterUser negative-case
    @Given("Post register new user with invalid request body {string}")
    public void postRegisterNewUserWithInvalidRequestBody(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }
    @Then("Response code admin should be {int} Bad Request")
    public void responseCodeAdminShouldBeBadRequest(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //POST RegisterUser negative-case--------
    @Given("Put update user with blank id {} request body {string}")
    public void putUpdateUserWithBlankIdRequestBody(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateUsersBlank(id, json);
    }

    //POST RegisterUser negative-case
    @Given("Post register new user with name value less than five characters {string}")
    public void postRegisterNewUserWithNameValueLessThanFiveCharacters(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }


    //POST RegisterClass positive-case
    @Given("Post register new class with valid request body {string}")
    public void postRegisterNewClassWithValidRequestBody(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewClass(json);
    }
    @When("Send post register new class")
    public void sendPostRegisterNewClass() {
        SerenityRest.when().post(ConstantAdmin.REGISTER_NEW_CLASS);
    }
    @And("Register new class response body contain {string}")
    public void registerNewClassResponseBodyContain(String name) {
        SerenityRest.and().body(ResponsesAdminMentutor.ARRAY_NAME, equalTo(name));
    }
    @And("Validate register new class JSON schema {string}")
    public void validateRegisterNewClassJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //POST RegisterClass positive-case
    @Given("Post register new class with class name value more than five characters {string}")
    public void postRegisterNewClassWithClassNameValueMoreThanCharacters(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewClassWithClassNameValueMoreThanChar(json);
    }

    //POST RegisterUser negative-case
    @Given("Post register new class with invalid request body {string}")
    public void postRegisterNewClassWithInvalidRequestBody(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }
    //POST RegisterUser negative-case
    @Given("Post register new class with blank request body {string}")
    public void postRegisterNewClassWithBlankRequestBody(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }
    //POST RegisterUser negative-case
    @Given("Post register new class with value contain special characters {string}")
    public void postRegisterNewClassWithValueContainSpecialCharacters(String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.postRegisterNewUser(json);
    }



    //GET GetAllUser positive-case
    @Given("Get all users with valid path")
    public void getAllUsersWithValidPath() {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getAllUsers();
    }
    @When("Send get all users")
    public void sendGetAllUsers() {
        SerenityRest.when().get(ConstantAdmin.GET_ALL_USERS);
    }
    @Then("Response code admin should be {int} OK")
    public void responseCodeAdminShouldBeOK(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }
    @And("Get all class response body contain {string}")
    public void getAllClassResponseBodyContain(String name) {
        SerenityRest.and().body(ResponsesAdminMentutor.ARRAY_NAME, equalTo(name));
    }
    @And("Validate get all users JSON schema {string}")
    public void validateGetAllUsersJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.GET_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET GetAllUser negative-case
    @Given("Get all users with invalid path")
    public void getAllUsersWithInvalidPath() {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getAllUsers();
    }
    @When("Send get all users fail")
    public void sendGetAllUsersFail() {
        SerenityRest.when().get(ConstantAdmin.GET_ALL_USERS_FAIL);
    }
    @Then("Response code admin should be {int} Not Found")
    public void responseCodeAdminShouldBeNotFound(int respCode) {
        SerenityRest.then().statusCode(respCode);
    }

    //GET GetAllClass positive-case
    @Given("Get all classes with valid path")
    public void getAllClassesWithValidPath() {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getAllClasses();
    }
    @When("Send get all classes")
    public void sendGetAllClasses() {
        SerenityRest.when().get(ConstantAdmin.GET_ALL_CLASSES);
    }
    @And("Get all classes response body contain {string}")
    public void registerNewClassesResponseBodyContain(String className) {
        SerenityRest.and().body(ResponsesAdminMentutor.ARRAY_CLASS_NAME, equalTo(className));
    }
    @And("Validate get all classes JSON schema {string}")
    public void validateGetAllClassesJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.GET_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET GetAllClass negative-case
    @Given("Get all classes with invalid path")
    public void getAllClassesWithInvalidPath() {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getAllUsers();
    }
    @When("Send get all classes fail")
    public void sendGetAllClassesFail() {
        SerenityRest.when().get(ConstantAdmin.GET_ALL_CLASSES_FAIL);
    }

    //GET GetOtherUser positive-case
    @Given("Get other user with valid id {int}")
    public void getOtherUserWithValidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getOtherUser(id);
    }
    @When("Send get other user")
    public void sendGetOtherUser() {
        SerenityRest.when().get(ConstantAdmin.GET_OTHER_USER);
    }
    @And("Get other user response body contain {string}")
    public void getOtherUserResponseBodyContain(String className) {
        SerenityRest.and().body(ResponsesAdminMentutor.CLASS_NAME, equalTo(className));
    }
    @And("Validate get other user JSON schema {string}")
    public void validateGetOtherUserJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.GET_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET GetOtherUser negative-case
    @Given("Get other user with invalid id {int}")
    public void getOtherUserWithInvalidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.getOtherUser(id);
    }
    @When("Send get other user fail")
    public void sendGetOtherUserFail() {
        SerenityRest.when().get(ConstantAdmin.GET_OTHER_USER);
    }



    //DELETE DeleteUser positive-case
    @Given("Delete user with valid id {}")
    public void deleteUserWithValidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.deleteUsers(id);
    }
    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ConstantAdmin.DELETE_USER_ID);
    }
    @And("Delete user response body contain {string}")
    public void deleteUserResponseBodyContain(String message) {
        SerenityRest.and().body(ResponsesAdminMentutor.MESSAGE, equalTo(message));
    }
    @And("Validate delete user JSON schema {string}")
    public void validateDeleteUserJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.DELETE_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //DELETE DeleteUser negative-case
    @Given("Delete user with invalid id {}")
    public void deleteUserWithInvalidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.deleteUsers(id);
    }

    //DELETE DeleteClass positive-case
    @Given("Delete class with valid id {}")
    public void deleteClassWithValidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.deleteClasses(id);
    }
    @When("Send delete class")
    public void sendDeleteClass() {
        SerenityRest.when().delete(ConstantAdmin.DELETE_CLASS_ID);
    }
    @And("Delete class response body contain {string}")
    public void deleteClassResponseBodyContain(String message) {
        SerenityRest.and().body(ResponsesAdminMentutor.MESSAGE, equalTo(message));
    }
    @And("Validate delete class JSON schema {string}")
    public void validateDeleteClassJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.DELETE_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //DELETE DeleteClass negative-case
    @Given("Delete class with invalid id {}")
    public void deleteClassWithInvalidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.deleteClasses(id);
    }



    //PUT UpdateUser positive-case
    @Given("Put update with valid id and body to name {string} " +
            "email {string} password {string} images {string} id_class {int}")
    public void putUpdateWithValidIdAndBodyToNameEmailPasswordImagesId_class
    (String name, String email, String password, String images, int id_class) {
        System.out.println(ConstantAdmin.IMAGES);
        File imageFile = new File(ConstantAdmin.IMAGES+images);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateUser(name,email,password,imageFile,id_class);
    }
    @When("Send put update")
    public void sendPutUpdate() {
        SerenityRest.when().put(ConstantAdmin.UPDATE_USER_ID);
    }
    @And("Put update user response body contain {string}")
    public void putUpdateUserResponseBodyContain(String message) {
        SerenityRest.and().body(ResponsesAdminMentutor.MESSAGE, equalTo(message));
    }
    @And("Validate put update user JSON schema {string}")
    public void validatePutUpdateUserJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.UPDATE_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //PUT UpdateUser positive-case
    @Given("Put update with name value more than five characters name {string} " +
            "email {string} password {string} images {string} id_class {int}")
    public void putUpdateWithNameValueMoreThanFiveCharactersNameEmailPasswordImagesId_class
    (String name, String email, String password, String images, int id_class) {
        System.out.println(ConstantAdmin.IMAGES);
        File imageFile = new File(ConstantAdmin.IMAGES+images);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateUser(name,email,password,imageFile,id_class);
    }

    //PUT UpdateUser negative-case
    @Given("Put update user with invalid id {}")
    public void putUpdateUserWithInvalidId(int id) {
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateUsersInvalid(id);
    }
    @When("Send put update user fail")
    public void sendPutUpdateUserFail() {
        SerenityRest.when().put(ConstantAdmin.UPDATE_USER_INVALIDID);
    }

    //PUT UpdateUser negative-case


    //PUT UpdateUser negative-case
    @Given("Put update user with name value less than five characters name {string} " +
            "email {string} password {string} images {string} id_class {int}")
    public void putUpdateUserWithNameValueLessThanFiveCharactersNameEmailPasswordImagesId_class
    (String name, String email, String password, String images, int id_class) {
        System.out.println(ConstantAdmin.IMAGES);
        File imageFile = new File(ConstantAdmin.IMAGES+images);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateUser(name,email,password,imageFile,id_class);
    }
    @When("Send put update user failed")
    public void sendPutUpdateUserFailed() {
        SerenityRest.when().put(ConstantAdmin.UPDATE_USER_ID);
    }

    //PUT UpdateClass positive-case
    @Given("Put update class with valid id {} and request body {string}")
    public void putUpdateClassWithValidRequestBody(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateClass(id, json);
    }
    @When("Send put update class")
    public void sendPutUpdateClass() {
        SerenityRest.when().put(ConstantAdmin.UPDATE_CLASS_ID);
    }
    @And("Put update class response body contain {string}")
    public void putUpdateClassResponseBodyContain(String message) {
        SerenityRest.and().body(ResponsesAdminMentutor.MESSAGE, equalTo(message));
    }
    @And("Validate put update class JSON schema {string}")
    public void validatePutUpdateClassJSONSchema(String jsonFile) {
        File json = new File(ConstantAdmin.UPDATE_JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //PUT UpdateClass positive-case
    @Given("Put update class with valid id {} and class name value more than five characters {string}")
    public void putUpdateClassWithValidIdAndClassNameValueMoreThanFveCharacters(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateClass(id, json);
    }

    //PUT UpdateClass negative-case
    @Given("Put update class with invalid id {} and valid request body {string}")
    public void putUpdateClassWithInvalidIdAndValidRequestBody(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateClass(id, json);
    }
    @When("Send put update class fail")
    public void sendPutUpdateClassFail() {
        SerenityRest.when().put(ConstantAdmin.UPDATE_CLASS_ID);
    }

    //PUT UpdateClass negative-case
    @Given("Put update class with valid id {} and invalid request body {string}")
    public void putUpdateClassWithValidIdAndInvalidRequestBody(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateClass(id, json);
    }

    //PUT UpdateClass negative-case
    @Given("Put update class with valid id {} and class name value less than five characters {string}")
    public void putUpdateClassWithValidIdAndClassNameValueLessThanFiveCharacters(int id, String jsonFile) {
        File json = new File(ConstantAdmin.REGISTER_REQ_BODY + jsonFile);
        adminMentutorAPI.login("AdminLogin.json");
        adminMentutorAPI.putUpdateClass(id, json);
    }



}