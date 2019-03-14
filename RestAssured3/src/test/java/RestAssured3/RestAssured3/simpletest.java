package RestAssured3.RestAssured3;

 
	import static io.restassured.RestAssured.*;
	import static io.restassured.module.jsv.JsonSchemaValidator.*;
	import java.io.IOException;
	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import org.testng.Assert;
	import org.testng.annotations.Test;



	public class simpletest extends BaseTest{
		
		final static String EP = "user_sessions_create";
		final static String RequestBody = BODY + EP + ".json";
		
		@Test
		public void test1() throws IOException {
			
			//Base URI and Path
			TestDataHandler.setBaseUrl(testDataJsonPath);
 	        TestDataHandler.setBasePath(testDataJsonPath, EP);
	    	
	    	//SuperUser
	    	String email = TestDataHandler.getSuperUserEmail(testDataJsonPath);
	    	String pwd = TestDataHandler.getSuperUserPwd(testDataJsonPath);
	     
			//Request Body
			String body = TestDataHandler.getRequestBody(RequestBody).replace("#{email}", email).replace("#{password}", pwd);
			 
			//Post Request
	    	res = given().contentType("application/json").body(body).post();
	    	System.out.println("RESSS");
	    	System.out.println(res.asString());
	        /*
	    	 ***Returns JsonPath object***
	    	 * First convert the API's response to String type with "asString()" method.
	    	 * Then, send this String formatted json response to the JsonPath class and return the JsonPath
	    	*/
	    	JsonPath json = new JsonPath(res.asString());
	    	
	    	//Check Status Code
	    	Assert.assertEquals(201, res.getStatusCode());
	    	
	    	//Check node of response
	    	Assert.assertEquals(TestDataHandler.getSuperUserEmail(testDataJsonPath), json.get("data.attributes.email"));
	    	
	    	//Print response with JSON format
	    	res.getBody().prettyPrint();
	    	
	    	//given().param("p1", "0").param("p2", "1").get("http://server/demo");
	    	//http://server/demo?p1=0&p2=1
	    	
	    	//JSON Schema Validation
	    	//get("https://server/demo?p1=0&p2=1").then().assertThat().body(matchesJsonSchemaInClasspath("test.json"));
	    	
		}
	
}
