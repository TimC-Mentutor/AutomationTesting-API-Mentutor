package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantForum;

import java.io.File;

public class ForumMentutorAPI {
    public static String GET_ALL_STATUS = ConstantForum.BASE_URL + "/{PATH}";

    @Step("Access the forum API with authentication token")
    public void accessForumWithAuthToken(String authToken,Object PATH) {
        SerenityRest.given()
                .pathParams("PATH",PATH)
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON);



    }
}
