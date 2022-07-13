package restAssuredTest;

import org.testng.annotations.Test;
import payloads.requestPayloads.ParseJsonRequest;
import util.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.*;


public class getRequest {

    ConfigReader configReader = new ConfigReader();
    @Test(priority = 1)
    public void getPlaceId(){
        System.out.println(given()
                .baseUri(configReader.properties.getProperty("baseURL"))
                        .queryParam("place_id","qaclick123").log().all()
                .when()
                .get("/maps/api/place/get/json")
        .then().log().all());
    }

    @Test(priority = 0, dataProvider = "name")
    public void postPlaceId() throws IOException {
       String response = given()
                .baseUri(configReader.properties.getProperty("baseURL")).log().all()
                        .header("Content-Type","application/json")
                        .body(ParseJsonRequest.requestPayload("createBookRecordRequest.json"))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all()
        .assertThat().statusCode(200)
                //.body("ID",startsWith("newRecord_123"))
                //.header("Server",equalTo("Apache/2.4.41 (Ubuntu)"))
                .extract().response().asString();
        ;
        /*AttributeByPath attributeByPath = new AttributeByPath();
        Assert.assertEquals(attributeByPath.getValueByJsonPath(response,"ID"),"newRecord_123");*/


        // to delete the created record
       /* given().header("Content-Type","application/json")
                .baseUri(configReader.properties.getProperty("baseURL"))
                .body("{\n" +
                        "\"ID\" : \"!@#$%^!@#$%^\"\n" +
                        "} \n")
                .when().post("/Library/DeleteBook.php")
                .then().assertThat().body("msg",equalTo("book is successfully deleted"));*/

    }


}
