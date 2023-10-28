package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantAdmin;

import java.io.File;

public class AdminMentutorAPI extends TokenAdmin {

    //post register user
        @Step("Post register new user")
    public void postRegisterNewUser(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register new user with  name value more than 5 characters")
    public void postRegisterNewUserWithNameValueMoreThanChar(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }

    //post register class
    @Step("Post register new class")
    public void postRegisterNewClass(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register new class with class name value more than 5 characters")
    public void postRegisterNewClassWithClassNameValueMoreThanChar(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }

    //get all users
    @Step("Get all users")
    public void getAllUsers() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON);
    }

    //get all classes
    @Step("Get all classes")
    public void getAllClasses() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON);
    }

    //get other user
    @Step("Get other users")
    public void getOtherUser(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }

    //put update user
    @Step("Put update user")
    public void putUpdateUser(String name,
                     String email,String password,
                     File images,int id_class){
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType("multipart/form-data")
                .multiPart("name", name)
                .multiPart("email", email)
                .multiPart("password", password)
                .multiPart("images", images)
                .multiPart("id_class", id_class);
    }

    @Step("Put update users invalid")
    public void putUpdateUsersInvalid(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }
//    @Step("Put update users blank")
//    public void putUpdateUsersBlank(int id, File json) {
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + getToken())
//                .contentType(ContentType.JSON)
//                .pathParam("id", id)
//                .body(json);
//    }
//put update class
@Step("Put update users blank")
public void putUpdateUsersBlank(int id, File json) {
    SerenityRest.given()
            .header("Authorization", "Bearer " + getToken())
            .contentType(ContentType.JSON)
            .pathParam("id", id)
            .body(json);
}


    //put update class
    @Step("Put update class")
    public void putUpdateClass(int id, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(json);
    }

    //delete user
    @Step("Delete users")
    public void deleteUsers(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }

    //delete class
    @Step("Delete classes")
    public void deleteClasses(int id) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }
}
