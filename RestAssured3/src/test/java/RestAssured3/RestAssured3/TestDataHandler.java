package RestAssured3.RestAssured3;
 
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import static io.restassured.RestAssured.*;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;

	public class TestDataHandler {
	    
	    public static JsonPath getTestDataJsonPath(String dataPath){
	    	return new JsonPath(dataPath);
	    }
	    
	    public static String getRequestBody(String path) throws IOException{
	    	String body = new String(Files.readAllBytes(Paths.get(path)));
	    	return body;
	    }
	    
	    public static void setBaseUrl (JsonPath jp){
	        RestAssured.baseURI = jp.get("base_url");
	    }
	    
	    public static void setBasePath (JsonPath jp, String testname){
	    	String base_path = testname + "." + "base_path";
	    	RestAssured.basePath = jp.get(base_path);
	    	 
	    }
	    /* public static void setBasePath (JsonPath jp){
	    	 
	    	RestAssured.basePath = jp.get("base_path");
	    	 
	    }*/
	 
	    public static Response getResponse(ContentType type, String path) {
	        return given().contentType(type).get(path);
	    }
	    
	    public static Response postResponse(ContentType type, String body) {
	        return given().contentType(type).body(body).post();
	    }
	    
	    public static String getSuperUserEmail(JsonPath jp){
	    	return jp.get("super_user.email");
	    }
	    
	    public static String getSuperUserPwd(JsonPath jp){
	    	return jp.get("super_user.password");
	    }
	    
	    public static String getInvalidUserEmail(JsonPath jp){
	    	return jp.get("invalid_user.email");
	    }
	    
	    public static String getInvalidUserPwd(JsonPath jp){
	    	return jp.get("invalid_user.password");
	    }
	    
	    public static String getUnauthorizedUserEmail(JsonPath jp){
	    	return jp.get("unauthorized_user.email");
	    }
	    
	    public static String getUnauthorizedUserPwd(JsonPath jp){
	    	return jp.get("unauthorized_user.password");
	    }
	    
	    public static String getTestNodeValue (JsonPath jp, String testname, String key){
	    	String node = testname + "." + key;
	    	return jp.get(node);
	    }

	}
 
