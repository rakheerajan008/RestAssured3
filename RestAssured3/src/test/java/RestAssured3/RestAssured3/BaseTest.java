package RestAssured3.RestAssured3;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class BaseTest {
	
    Response res = null;
    JsonPath testDataJsonPath = null;
    static final String BODY = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\";
    
	@BeforeTest
	@Parameters({"env"})
	public void setup(@Optional("dev") String env) throws Exception {	
		String testfilepath = "";
		if (env.equalsIgnoreCase("dev")) {
			testfilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\testdata.json";
		}
		else if (env.equalsIgnoreCase("uat")){
			testfilepath = System.getProperty("user.dir") + "/data/uat/testdata.json";
		}
		String content = new String (Files.readAllBytes(Paths.get(testfilepath)));
		 
		testDataJsonPath = TestDataHandler.getTestDataJsonPath(content);
  	}

	
	@AfterTest
	public void teardown() {

	}
	
}
