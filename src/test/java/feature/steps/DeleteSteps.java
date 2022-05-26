package feature.steps;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.api.DeleteRequest;
import org.junit.Assert;

public class DeleteSteps {

    private final DeleteRequest deleter;

    public DeleteSteps(){
        deleter = new DeleteRequest();
    }

    @Given("^a file to be deleted$")
    public void aFileToBeDeleted() {
    }

    @When("^a file is deleted$")
    public void aFileIsDeleted() throws UnirestException {
        deleter.delete();
    }

    @Then("^deleting is successful$")
    public void deletingIsSuccessful() {
        int responseStatusCode = deleter.getResponse().getStatus();
        if (responseStatusCode != 200)
        {
            Assert.fail("Unable to delete. status code: " + responseStatusCode);
        }
    }
}
