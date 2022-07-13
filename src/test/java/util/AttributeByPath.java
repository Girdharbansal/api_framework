package util;

import io.restassured.path.json.JsonPath;

public class AttributeByPath {

    public Object getValueByJsonPath(String response, String attributePath){
        JsonPath jp = new JsonPath(response);
        return  jp.getString(attributePath);
    }
}
