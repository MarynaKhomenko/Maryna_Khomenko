package feature.steps;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.api.UploadRequest;
import org.junit.Assert;

public class UploadSteps {
    private final UploadRequest uploader;

    public UploadSteps(){
        uploader = new UploadRequest();
    }

    @Given("^a file to upload$")
    public void aFileToUpload() {
    }

    @When("^a file is uploaded$")
    public void aFileIsUploaded() throws UnirestException {
        uploader.upload();
    }

    @Then("^uploading is successful$")
    public void uploadingIsSuccessful() {
        int responseStatusCode = uploader.getResponse().getStatus();
        if (responseStatusCode != 200)
        {
            Assert.fail("Unable to upload the file. status code: " + responseStatusCode);
        }
    }
}
