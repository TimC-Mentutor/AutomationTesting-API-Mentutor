package starter.mentutor;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantLogin;

import java.io.File;

public class LoginMentutorAPI {

    public static String POST_LOGIN = ConstantLogin.BASE_URL+"/login";


    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


}
