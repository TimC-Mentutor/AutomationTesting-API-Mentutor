package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.mentutor.LoginMentutorAPI;
import starter.utils.ConstantLogin;

import java.io.File;

public class LoginStepDef {

    @Steps
    LoginMentutorAPI loginMentutorAPI;

//  CASE 1
    @Given("Post login with valid admin email and password {string}")
    public void createUserWithValidAdminEmailAndPassword(String jsonFile) {
        File json = new File(ConstantLogin.REQ_BODY+jsonFile);
        loginMentutorAPI.postLogin(json);
    }

    @When("Send request login with valid admin email and password")
    public void sendRequestUserWithValidAdminEmailAndPassword() {
        SerenityRest.when().post(loginMentutorAPI.POST_LOGIN);
    }

    @Then("Status code login should be {int} ok")
    public void statusCodeLoginShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
//  CASE 2
    @Given("Post login with valid mentor email and password {string}")
    public void createUserWithValidMentorEmailAndPassword(String jsonFile) {
        File json = new File(ConstantLogin.REQ_BODY+jsonFile);
        loginMentutorAPI.postLogin(json);
    }

    @When("Send request login with valid mentor email and password")
    public void sendRequestUserWithValidMentorEmailAndPassword() {
        SerenityRest.when().post(loginMentutorAPI.POST_LOGIN);
    }
//  CASE 3
    @Given("Post login with valid mentee email and password {string}")
    public void createUserWithValidMenteeEmailAndPassword(String jsonFile) {
        File json = new File(ConstantLogin.REQ_BODY+jsonFile);
        loginMentutorAPI.postLogin(json);
    }

    @When("Send request login with valid mentee email and password")
    public void sendRequestUserWithValidMenteeEmailAndPassword() {
        SerenityRest.when().post(loginMentutorAPI.POST_LOGIN);
    }

//    CASE 4
    @Given("Post login with unregistered email and password {string}")
    public void postLoginWithUnregisteredEmailAndPassword(String jsonFile) {
        File json = new File(ConstantLogin.REQ_BODY+jsonFile);
        loginMentutorAPI.postLogin(json);
    }

    @When("Send request login with unregistered email and password")
    public void sendRequestLoginWithUnregisteredEmailAndPassword() {
        SerenityRest.when().post(loginMentutorAPI.POST_LOGIN);
    }
    @Then("Status code login should be {int} not found")
    public void statusCodeLoginShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

//    CASE 5
    @Given("Post login with wrong password {string}")
    public void postLoginWithWrongPassword(String jsonFile) {
        File json = new File(ConstantLogin.REQ_BODY+jsonFile);
        loginMentutorAPI.postLogin(json);
    }

    @When("Send request login with wrong password")
    public void sendRequestLoginWithWrongPassword() {
        SerenityRest.when().post(loginMentutorAPI.POST_LOGIN);
    }

    @Then("Status code login should be {int} bad request")
    public void statusCodeLoginShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

}
