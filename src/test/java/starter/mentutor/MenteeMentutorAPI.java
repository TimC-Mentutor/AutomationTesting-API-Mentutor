package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantMentee;

import java.io.File;

public class MenteeMentutorAPI extends TokenMentee {


    public static String GET_ALL_TASK = ConstantMentee.BASE_URL + "/mentees/{PATH}";
    public static String POST_TASK = ConstantMentee.BASE_URL + "/mentees/submission/{PATH}";
    public static String POST_COMMENT = ConstantMentee.BASE_URL + "/forum/{PATH}";
    public static String PUT_UPDATE = ConstantMentee.BASE_URL + "/users";


    @Step("Get all task ")
    public void getAllTask(Object PATH) {
        SerenityRest.given()
                .pathParams("PATH", PATH)
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON);
    }
    @Step("Post task")
    public void postTask(Object PATH, File pdfFile) {
        SerenityRest.given()
                .pathParams("PATH", PATH)
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .contentType("multipart/form-data")
                .multiPart("file",pdfFile);
    }
    @Step("Post task with empty file")
    public void postTaskWithEmptyFile(Object PATH) {
        SerenityRest.given()
                .pathParams("PATH", PATH)
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON);
    }

    @Step("Post comment")
    public void postComment(Object PATH,File json) {
        SerenityRest.given()
                .pathParams("PATH", PATH)
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post comment with multi form")
    public void postCommentWithForm(Object PATH, Object caption) {
        SerenityRest.given()
                .pathParams("PATH", PATH)
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .contentType("multipart/form-data")
                .multiPart("caption",caption);
    }

    @Step("Put Update with form")
    public void putUpdateWithForm(Object name,Object email,Object password,Object images){
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .multiPart("name",name)
                .multiPart("email",email)
                .multiPart("password",password)
                .multiPart("images",images);
    }
    @Step("Put update with json")
    public void putUpdateWithJson(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(json);
    }

}