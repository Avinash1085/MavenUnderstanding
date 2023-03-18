package testNGPackage;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ReqRespAPITest {
	
	private static final String SYSDATE = null;

	@Test
	  public void check_status_code_is_200() 
	  {
	    
	  RestAssured.baseURI= "https://reqres.in";
	  RequestSpecification httpRequest = RestAssured.given();
	  Response response = httpRequest.get("/api/users?id=1");
	  System.out.println("StatusCode of my Response is : "+response.statusCode());
//	  Assert.assertEquals(response.statusCode(),201);//This is also working fine
		  if(response.statusCode()==201) //but anyway this will pass the test so better use Assrt.assertequals
		  {
			  System.out.println("Response code is generateted properly");
		  }
		  else
		  {
			  System.out.println("ResponseCode is Incorrect.");
		  }
	  	}
  @Test
  public void find_specific_string_from_response() 
  {
    
  RestAssured.baseURI= "https://reqres.in";
  RequestSpecification httpRequest = RestAssured.given();
//  Response response = httpRequest.get("/api/users?id=1");//Here also we can pass URL including Queryparameters directly like we did in this statement
 
  //Using Query Parameters
  Response response = httpRequest.queryParam("id","1").get("/api/users");
  
   httpRequest.auth().oauth2(SYSDATE).body("").post();
  

  // Retrieve the body of the Response
  ResponseBody body = response.getBody();
  
  JsonPath json=response.jsonPath();
    
    
  // To check for sub string presence get the Response body as a String.
  // Do a String.contains
  String bodyAsString = body.asString();
//  System.out.println(bodyAsString);
  System.out.println(body.prettyPrint());
  
  // convert the body into lower case and then do a comparison to ignore casing.
  Assert.assertEquals(bodyAsString.toLowerCase().contains("george") /*Expected value*/, true /*Actual Value*/, "Response body contains George");
  }
  
  @Test
  public void validate_response_Field()
  {
	  RestAssured.baseURI="https://reqres.in";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response=httpRequest.get("/api/users?id=2");  //queryParameter
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  
	  System.out.println("ID of User : "+jsonPathEvaluator.get("data.id"));
	  System.out.println("Email_ID of User : "+jsonPathEvaluator.get("data.email"));
	  System.out.println("FirstName of User : "+jsonPathEvaluator.get("data.first_name"));
	  System.out.println("LastName of User : "+jsonPathEvaluator.get("data.last_name"));
	  System.out.println("Avatar of User : "+jsonPathEvaluator.get("data.avatar"));

	  System.out.println("Support URL of User : "+jsonPathEvaluator.get("support.url"));
	  System.out.println("Support Text of User : "+jsonPathEvaluator.get("support.text"));

	  int statusCode=response.getStatusCode();
	  String statusLine=response.getStatusLine();
	  Headers respHeader=response.getHeaders();//This fetches all headers
	  
	  System.out.println("StatusCode: "+statusCode);
	  System.out.println("statusLine : "+statusLine);
	  System.out.println("Headers : "+respHeader);//This prints all headers

	  
	  System.out.println("Headers : "+respHeader.getValue("Date"));//will print the value of Date header
	  System.out.println(SYSDATE);
//	  Assert.assertEquals(respHeader.getValue("Date"), SYSDATE);
	  String OK="OK";

//	  Assert.assertEquals(OK,statusLine.contains("OK"));
	  Assert.assertTrue(statusLine.contains("OK"), OK);
	  
	  
	  ResponseBody body=response.body();
	  System.out.println("Response Body is :\n"+body.prettyPrint());
  }
  
}
