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

public class PutOperations {
	
	RequestSpecification req;
	Response res;
	ValidatableResponse  validate;
	
	@Given("user wants to update the existing the data")
	public void user_wants_to_update_the_existing_the_data() {
	   JSONObject JS=new JSONObject();
		//JS.put("id",);
		JS.put("mAbout","manish");
		JS.put("mArea","qspider");
		JS.put("mName","manu");
		JS.put("mPin",23);
		JS.put("mid","SATYA_SHOPPINGMALL_00059");
		req= RestAssured.given();
		req.body(JS);
		req.contentType(ContentType.JSON);
	}
		
	

	@When("User put the data using  an api {string}")
	public void user_put_the_data_using_an_api(String url) {
		res= req.post(url)  ;
	}

	@Then("User Checks the status code is {int}")
	public void user_checks_the_status_code_is(Integer int1) {
		validate = res .then();
	    validate.assertThat()
        .body("data.mid", equalTo("SATYA_SHOPPINGMALL_00059"))
		.body( "data.mName" ,equalTo("manu"))
	    .body( "data.mPin" ,equalTo(23))
		.body("data.mArea", equalTo("qspider"))
		.body( "data.mAbout" ,equalTo("manish"))
	    .statusCode(int1);
	    validate.log().all();
	}

	@Then("User also checks the contentType")
	public void user_also_checks_the_content_type() {
	//	Validate = res .then();
	    validate.assertThat().contentType(ContentType.JSON);
	   // Validate.log().all();
	}

}
//"mid": "SATYA_SHOPPINGMALL_00059",
//"mName": "manu",
//"mPin": 23,
//"mArea": "qspider",
//"mAbout": "manish"