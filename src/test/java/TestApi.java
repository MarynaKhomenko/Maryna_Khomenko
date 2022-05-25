import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestApi {

    private static final String ACCESS_TOKEN = "sl.BIRvWrWWq_7lySOzYaFNav3OG3Kd56kalzNk06iIWRpQyrjtjekXOeJYBrCdUBiGuyngivfC92Bo6aI6JTMjS0JWT2RRfxNWX4paVWis2mwTE4Sg4cvZVRCimaxigpku1REbIYkR";

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    public void createFile(String path) throws IOException {
        JSONObject jsonCreate = new JSONObject();
        jsonCreate.put("mode","add");
        jsonCreate.put("autorename", true);
        jsonCreate.put("path", path);

        File file = new File("text.txt");

        RestAssured.given()
                .headers("Dropbox-API-Arg",jsonCreate.toJSONString(),
                        "Content-Type","text/plain; charset=dropbox-cors-hack",
                        "Authorization", "Bearer " + ACCESS_TOKEN)
                .body(FileUtils.readFileToByteArray(file))
                .post("https://content.dropboxapi.com/2/files/upload");
    }

    public void deleteFile(String path){
        JSONObject json = new JSONObject();
        json.put("path", path);

        RestAssured.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN,
                        "Content-Type","application/json")
                .body(json.toJSONString())
                .post("https://api.dropboxapi.com/2/files/delete_v2");
    }

    @Test
    public void A_uploadTest() throws IOException {

        disableWarning();

        JSONObject json = new JSONObject();
        json.put("mode","add");
        json.put("autorename", true);
        json.put("path","/texx.txt");

        File file = new File("text.txt");

        RestAssured.given()
                .headers("Dropbox-API-Arg",json.toJSONString(),
                        "Content-Type","text/plain; charset=dropbox-cors-hack",
                        "Authorization", "Bearer " + ACCESS_TOKEN)
                .body(FileUtils.readFileToByteArray(file))
                .when().post("https://content.dropboxapi.com/2/files/upload")
                .then().statusCode(200);

        deleteFile("/texx.txt");
    }

    @Test
    public void B_getMetadataTest() throws IOException {

        disableWarning();

        JSONObject json = new JSONObject();
        json.put("path","/meta.txt");

        createFile("/meta.txt");

        RestAssured.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN,
                        "Content-Type","application/json")
                .body(json.toJSONString())
                .when().post("https://api.dropboxapi.com/2/files/get_metadata")
                .then().statusCode(200);
        deleteFile("/meta.txt");
    }

    @Test
    public void C_deleteTest() throws IOException {

        disableWarning();

        JSONObject json = new JSONObject();
        json.put("path","/delete.txt");
        createFile("/delete.txt");

        RestAssured.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN,
                        "Content-Type","application/json")
                .body(json.toJSONString())
                .when().post("https://api.dropboxapi.com/2/files/delete_v2")
                .then().statusCode(200);
    }
}
