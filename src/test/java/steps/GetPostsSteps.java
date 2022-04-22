package steps;


//import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;

//import cucumber.api.java.en.When;
import io.restassured.response.Response;

import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtention;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class GetPostsSteps {

    public static String token;
    private static ResponseOptions<Response> response;

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {

        response = RestAssuredExtention.getOps(url);

        System.out.println(response.statusCode());
    }


    @Then("^I should see author name as \"([^\"]*)\"$")
    public void iShouldSeeAuthorNameAs(String authorName) throws Throwable {

      // assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));

    }

    @Then("^I should see author names$")
    public void iShouldSeeAuthorNames() {

        BDDStyleMethod.performContainsCollection();

        //  assertThat(response.getBody().jsonPath().get("author"), containsInAnyOrder("Vinayak","Angel","Koli","Josh",null,"Vinayak 2.7"));
    }


    @Then("^I should see perform GET parameters \"([^\"]*)\" and see author name as \"([^\"]*)\"$")
    public void iShouldSeePerformGETParametersAndSeeAuthorNameAs(String postNumber, String authorName) throws Throwable {

        BDDStyleMethod.performPathParameter(postNumber,authorName);


    }


    @Then("^For GET parameters \"([^\"]*)\" I see author name as \"([^\"]*)\"$")
    public void forGETParametersISeeAuthorNameAs(String postNumber, String authorName) throws Throwable {
        BDDStyleMethod.performPathParameter(postNumber,authorName);
    }



    @Then("^I should see perform query parameters for GET$")
    public void iShouldSeePerformQueryParametersForGET() {
        BDDStyleMethod.performQueryParameter();
    }

    @Then("^I should see perform body parameters for GET$")
    public void iShouldSeePerformBodyParametersForGET() {
        BDDStyleMethod.performBodyParamerter();
    }

    @Given("^I perform  post operation with ([^\"]*) and ([^\"]*) and ([^\"]*)$")
    public void iPerformPostOperationWithIdAndTitleAndAuthor(String id,String title, String author) {
        RestAssuredExtention.PostWithScenarioOutline(id,title,author);
    }
}

