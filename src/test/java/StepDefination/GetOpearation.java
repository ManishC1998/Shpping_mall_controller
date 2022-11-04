package StepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetOpearation {

	RequestSpecification req;
	Response res;
	ValidatableResponse  validate;
	
	@When("User is able to get all data by using api is {string}")
	public void user_is_able_to_get_all_data_by_using_api_is(String url) {
	   res=RestAssured.get(url);
	}

	@Then("User is checks whether the status code is {int}")
	public void user_is_checks_whether_the_status_code_is(Integer int1) {
		validate = res .then();
	    validate.assertThat().statusCode(int1);
	    validate.contentType(ContentType.JSON);
	    validate.log().all();
	}
}
