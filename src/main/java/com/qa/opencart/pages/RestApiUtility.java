package com.qa.opencart.pages;

import com.google.gson.JsonObject;
import com.qa.opencart.factory.DriverFactory;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

public class RestApiUtility
{


public  void GetApi(String URL,int StatusCode)
{
    RestAssured.get(URL).then().assertThat().statusCode(StatusCode).log().all().extract();

}

public void PostApi(String HeaderContentType , Object body , int StatusCode , String PostUrl)
{
    RestAssured.given().header("Content-Type", HeaderContentType).body(body).when().post(PostUrl).then().assertThat().statusCode(StatusCode).log().all().extract().response();

}

public  void deleteApi(String URL,int StatusCode)
{
    RestAssured.given().when().delete(URL).then().assertThat().statusCode(StatusCode).log().all().extract();

}

public void JsonPost(Object name1,Object job,String URL,int ResponseCode){
    JSONObject js = new JSONObject();
    js.put("name",name1);
    js.put("job",job);
    RestAssured.given().body(js.toJSONString()).when().post(URL).then().assertThat().statusCode(ResponseCode).log().all().extract();
}



}
