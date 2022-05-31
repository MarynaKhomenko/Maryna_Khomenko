package feature.steps;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.api.MetadataRequest;
import org.junit.Assert;

public class MetadataSteps {
    private final MetadataRequest metadataReceiver;

    public MetadataSteps(){
        metadataReceiver = new MetadataRequest();
    }

    @When("^a metadata is received$")
    public void aMetadataIsReceived() throws UnirestException {
        metadataReceiver.metadataReceive();
    }

    @Then("^a metadata receiving is successful$")
    public void aMetadataReceivingIsSuccessful() {
        int responseStatusCode = metadataReceiver.getResponse().getStatus();
        if (responseStatusCode != 200)
        {
            Assert.fail("Unable to receive the metadata. status code: " + responseStatusCode);
        }
    }
}
