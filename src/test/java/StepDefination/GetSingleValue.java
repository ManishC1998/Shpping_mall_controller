package StepDefination;

import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetSingleValue {
		RequestSpecification req;
		Response res;
		ValidatableResponse  validate;
	
	@When("User is able to get single data with the help of  using api is {string}")
	public void user_is_able_to_get_single_data_with_the_help_of_using_api_is(String url) {
		 res=RestAssured.get(url);
	}

	@Then("User should be  checks whether the status code is {int}")
	public void user_should_be_checks_whether_the_status_code_is(Integer int1) {
		validate = res .then();
	    validate.assertThat()
	    .body("data.mName", equalTo("Aniket"))
	   .body( "data.mPin" ,equalTo(3))
	   .body("data.mArea", equalTo("Qspider"))
	   .body( "data.mAbout" ,equalTo("Students"))

	   
//        "mPin": 3,
//        "mArea": "Qspider",
//        "mAbout": "Students"
	    .statusCode(int1);
	    validate.log().all();
	}
}
