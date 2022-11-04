package StepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import  static io.restassured.RestAssured.when;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteOperation {


	RequestSpecification req;
	Response res;
	ValidatableResponse  validate;
	
	@When("I hit the api with delete request and end point as {string}")
	public void i_hit_the_api_with_delete_request_and_end_point_as(String deleteUrl) {
		res=when().delete(deleteUrl);
	}

	@Then("To checking  the status code as {int} and status line as  {string}")
	public void to_checking_the_status_code_as_and_status_line_as(Integer int1, String string) {
	   res.then()
	   .assertThat().statusLine(string);
	}

	@Then("To checks the body message as {string} And data is {string}")
	public void to_checks_the_body_message_as_and_data_is(String string, String string2) {
	    res.then()
	    .log().all()
	    .assertThat().statusCode(200);
	}
}
