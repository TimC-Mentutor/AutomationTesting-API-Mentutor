package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.ConstantForum;

import java.io.File;

public class TokenMentee {
    String token;

    public void login(String bodyFile){
        File jsonFile = new File(ConstantForum.REQ_BODY+bodyFile);
        this.token = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .post(ConstantForum.BASE_URL+"/login")
                .then().contentType(ContentType.JSON).extract().response()
                .jsonPath()
                .get("data.token");
    }
    public String getToken() {
        return token;
    }
}