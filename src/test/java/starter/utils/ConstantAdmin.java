package starter.utils;

public class ConstantAdmin {
    public static String BEARER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZENsYXNzIjowLCJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2OTgyOTIwMTAsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.TqPEP-BduQMx98CdI_dvbyBm3QDAEcNbu7Pro63bcHA";
    public static String BASE_URL = "https://mentutor.altapro.online";
    public static String DIR = System.getProperty("user.dir");
    public static String IMAGES = DIR+"/src/test/resources/Images/";

    //post
    public static String REGISTER_NEW_USER = BASE_URL + "/admin/users";
    public static String REGISTER_NEW_CLASS = BASE_URL + "/admin/classes";
    public static String REGISTER_REQ_BODY = DIR + "/src/test/resources/JSON/ReqBody/";
    public static String REGISTER_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/";

    //get
    public static String GET_ALL_USERS = BASE_URL + "/admin/users";
    public static String GET_OTHER_USER = BASE_URL + "/admin/users/{id}";
    public static String GET_ALL_CLASSES = BASE_URL + "/admin/classes";
    public static String GET_ALL_USERS_FAIL = BASE_URL + "/admin/usersx";
    public static String GET_ALL_CLASSES_FAIL = BASE_URL + "/admin/classesx";
    public static String GET_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/";

    //put
    public static String UPDATE_USER_ID = BASE_URL + "/admin/users/{id}}";
    public static String UPDATE_CLASS_ID = BASE_URL + "/admin/classes/{id}";
    public static String UPDATE_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/";

    //delete
    public static String DELETE_USER_ID = BASE_URL + "/admin/users/{id}";
    public static String DELETE_CLASS_ID = BASE_URL + "/admin/classes/{id}";
    public static String DELETE_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JSONSchema/";
}
