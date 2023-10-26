package starter.mentutor;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantForum;

import java.io.File;

public class ForumMentutorAPI extends TokenMentee {
    public static String GET_ALL_STATUS = ConstantForum.BASE_URL + "/{PATH}";
    public static String POST_FORUM = ConstantForum.BASE_URL + "/forum";

    @Step("Access the forum API with authentication token")
    public void accessForumWithAuthToken(Object PATH) {
        SerenityRest.given()
                .pathParams("PATH",PATH)
                .header("Authorization", "Bearer "+ getToken())
                .contentType(ContentType.JSON);
    }
    @Step("POST Forum")
    public void postForum(File imageFile,String caption) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType("multipart/form-data")
                .multiPart("images", imageFile)
                .multiPart("caption",caption);
    }
    @Step("POST Forum Tanpa gambar")
    public void postForumTanpaGambar(String caption) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + getToken())
                .contentType("multipart/form-data")
                .multiPart("caption",caption);
    }
}
