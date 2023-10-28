package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.ConstantMentor;

import java.io.File;

public class Token {
    String token;

    public void login(String bodyFile){
        File jsonFile = new File(ConstantMentor.REQ_BODY+bodyFile);
        this.token = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .post(ConstantMentor.BASE_URL+"login")
                .then().contentType(ContentType.JSON).extract().response()
                .jsonPath()
                .get("data.token");
    }
    public String getToken() {
        return this.token;
    }
}
