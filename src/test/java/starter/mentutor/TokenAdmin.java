package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.ConstantAdmin;

import java.io.File;
public class TokenAdmin {
        String token;

        public void login(String bodyFile){
            File jsonFile = new File(ConstantAdmin.UPDATE_USER_ID+bodyFile);
            this.token = SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(jsonFile)
                    .post(ConstantAdmin.BASE_URL+"/login")
                    .then().contentType(ContentType.JSON).extract().response()
                    .jsonPath()
                    .get("data.token");
        }
        public String getToken() {
            return this.token;
        }
}
