package starter.mentutor;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.ConstantMentor;

import java.io.File;

public class MentorMentutorApi extends Token{
 public static String UPDATE_PROFILE_MENTOR = ConstantMentor.BASE_URL+"users";
 public static String GET_LIST_TASK = ConstantMentor.BASE_URL+"mentors/tasks/";
 public static String GET_LIST_TASK_WITH_PARAM = ConstantMentor.BASE_URL+"mentors/tasks?title={title}";
 public static String GET_TASK_VALID_ID = ConstantMentor.BASE_URL+"mentors/tasks/{id}";
 public static String PUT_UPDATE_TASK = ConstantMentor.BASE_URL+"mentors/tasks/{id}";
 public static String POST_ADD_TASK = ConstantMentor.BASE_URL+"mentors/tasks";
 public static String POST_ADD_COMMENT = ConstantMentor.BASE_URL+"forum/{id status}";
 public static String POST_SUBMIT_SCORE = ConstantMentor.BASE_URL+"mentors/submission/{id_submission}";
 public static String DELETE_TASK = ConstantMentor.BASE_URL+"mentors/tasks/{id_task}";







 //    ------------PUT UPDATE PROFILE MENTOR-----------
    @Step("Put update profile mentor")
    public void putUpdateProfile(String name,String email,String password,File imageFile) {
    SerenityRest.given()
            .contentType("multipart/form-data")
            .multiPart("name", name)
            .multiPart("email", email)
            .multiPart("password",password)
            .multiPart("images", imageFile);
}
    @Step("Put update profile mentor")
    public void putUpdateTask(int id,String title,String description,String due_date,File docsFile,File imageFile) {
    }
    @Step("Put update profile mentor")
    public void putUpdateTaskInvalidId(String id,String title,String description,String due_date,File docsFile,File imageFile) {
    }
//    ------------GET METHOD-----------
//    @Step("Get list task")
//  public void getListTask (String authToken){
//   SerenityRest.given()
//           .contentType(ContentType.JSON);
//  }
//  @Step("Get all task with valid query param")
//    public void getAllTaskWithQuery(String title,String authToken) {
//
//
//  }
//  @Step("Get task detail with valid id")
//    public void getDetailTaskValidId(int id,String authToken){
//      SerenityRest.given()
//              .headers("Authorization", "Bearer " + authToken)
//              .pathParam("id", id);
//  }
//    @Step("Get task detail using special char on id")
//    public void getTaskSpecialChar(String id,String authToken){
//        SerenityRest.given()
//                .headers("Authorization", "Bearer " + authToken)
//                .pathParam("id", id);
//    }
//    @Step("Put update profile mentor with valid name")
//    public void putUpdateProfileValidName(String name,String email,String password,String images){
//    }
    @Step("Add task by mentor")
    public void addTaskByMentor(String title,String description,String due_date,File docsFile,File imageFile){}
 }

