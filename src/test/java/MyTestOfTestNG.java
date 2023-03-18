import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class MyTestOfTestNG 
{
    	@Test
    	public void get_all_Employee_Details() 
    	{
		  RestAssured.baseURI="http://localhost:8089";
		  given().when().get("/employees").then().extract().response().print();//.statusCode(200)
    	}
    	
    	@Test
    	public void creat_New_Employee()
    	{
    		RestAssured.baseURI="http://localhost:8089";
    		Map<String,String> headers=new HashMap<>();
    		headers.put("Content-Type","application/json");
    		given()
    		.when().headers(headers).body("{\"eno\":6, \"name\":\"Kranti\"}").post("/employees")
//    		.when().headers(headers).body("{\"eno\": 5,    \"name\": \"Tanvi\"}").post("/employees")
//    		.when().headers(headers).body("{\n"
//    				+ "    		    \"name\": \"Avinash\",\n"
//    				+ "    		    \"eno\": 1\n"
//    				+ "    		}").post("/employees")    		
    		.then().statusCode(201).extract().response().prettyPrint();
    	}
    	
    	@Test
    	public void new_Emp_Json_Payload()
    	{
    		RestAssured.baseURI="http://localhost:8089";
    		RequestSpecification httpReq=RestAssured.given();
    		JSONObject reqParameters=new JSONObject();
    		reqParameters.put("eno", 2);
    		reqParameters.put("name", "Ganesh");
    		
    		httpReq.header("Content-Type","application/json");
    		httpReq.body(reqParameters.toJSONString());
    		Response response=httpReq.post("/employees");
    		ResponseBody body=response.getBody();
    		System.out.println("ResponseBody is : "+body.prettyPrint());
    	}
    	
    	
    	@Test(dataProvider="empData")
    	public void create_Emp_Using_DP(String name,Integer id)
    	{
    		RestAssured.baseURI="http://localhost:8089";
    		Map<String , Object> data=new HashMap<String, Object>();
    		data.put("name", name);
    		data.put("id", id);
    		Map<String,String> headers=new HashMap<>();
    		headers.put("Content-Type","application/json");
    		given().when().headers(headers).body(data).log().all().post("/employees").then().log().all().assertThat().statusCode(201);
    	}
    	
    	@DataProvider
    	public Object[][] empData()
    	{
    		Object[][] data=new Object[2][2];
    		data[0][0]="Ganesh";
    		data[0][1]=1;
    		
    		data[1][0]="Ramesh";
    		data[1][1]=2;
    		return data;
    	}
    	
    	@Test
    	public void reqRespAPI_get_specific_User_using_QueryParameter()
    	{
    		RestAssured.baseURI="https://reqres.in";
    		given()
    		.when()
    		.get("/api/users?id=1") //Used Query parameter here i.e ?id=1
    		.then().extract().response().prettyPrint();
    	}
    	
    	@Test
    	public void reqRespAPI_get_All_Users()
    	{
    		RestAssured.baseURI="https://reqres.in";
    		given()
    		.when()
    		.get("/api/users")
    		.then().extract().response().prettyPrint();
    	}
    	
       	@Test
    	public void reqRespAPI_Validate_StatusCode_of_response()
    	{
    		RestAssured.baseURI="https://reqres.in";
    		given()
    		.when()
    		.get("/api/users")
    		.then().statusCode(200);
    	}
       	
     	@Test
    	public void reqRespAPI_Print_StatusCode_of_response_on_console()
    	{
    		RestAssured.baseURI="https://reqres.in";
    		given()
    		.when()
    		.get("/api/users")
    		.then().extract().response().getBody();
    	}
}
