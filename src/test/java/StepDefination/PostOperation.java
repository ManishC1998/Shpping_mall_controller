package StepDefination;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostOperation {
	
	RequestSpecification req;
	Response res;
	ValidatableResponse  validate;
	 
	  @Given("user wants to provide the data")
	   public void user_wants_to_provide_the_data()
	  {
		JSONObject JS=new JSONObject();
		JS.put("mAbout","manish");
		JS.put("mArea","qspider");
		JS.put("mName","manu");
		JS.put("mPin",23);
		JS.put("mid","2");
		                     
          	req= RestAssured.given();
          	req.body(JS);
          	req.contentType(ContentType.JSON);
	}
	@When("User post the data by using the api is {string}")
	public void user_post_the_data_by_using_the_api_is(String url) 
	{
		res= req.post(url)  ;
	}
	@Then("User checks the Status code is {int}")
	public void user_checks_the_status_code_is(Integer int1) 
	{
		validate = res .then();
	    validate.assertThat()
	   // .body("data.mid", equalTo("4"))
	    
	    .body("data.mName", equalTo("manu"))
		   .body( "data.mPin" ,equalTo(23))
		   .body("data.mArea", equalTo("qspider"))
		   .body( "data.mAbout" ,equalTo("manish"))

	    .statusCode(int1);
	    validate.assertThat().statusLine("HTTP/1.1 200 ");
	    validate.contentType(ContentType.JSON);
	    
	    validate.log().all();
	}
}
//	
//	@Given("user wants to provide the data")
//	public void user_wants_to_provide_the_data() {
//		JSONObject JS=new JSONObject();
//		JS.put("mAbout","manish");
//		JS.put("mArea","qspider");
//		JS.put("mName","manu");
//		JS.put("mPin","employee");
//		JS.put("mid","2");
//		
//		req= RestAssured.given();
//		req.body(JS);
//		req.contentType(ContentType.JSON);
//		
//		
//	   "mid": "2",
//"mName": "manu",
//"mPin": 23,
//"mArea": "qspider",
//"mAbout": "manish"
//	}
//
//	@When("User post the data by using the api is {string}")
//	public void user_post_the_data_by_using_the_api_is(String url) {
//		res= req.post(url)  ;
//	}
//
//	@Then("User checks the Status code is {int}")
//	public void user_checks_the_status_code_is(Integer int1) {
//		Validate = res .then();
//	    Validate.assertThat().statusCode(int1);
//	    Validate.log().all();
//	    
//	}
//
//}
//
