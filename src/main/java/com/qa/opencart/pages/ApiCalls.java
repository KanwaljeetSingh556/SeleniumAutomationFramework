package com.qa.opencart.pages;


import org.testng.annotations.Test;

public class ApiCalls
{
     static RestApiUtility a;
    public ApiCalls()
    {
         a = new RestApiUtility();

    }

    @Test
   public void get()
    {

        a.GetApi("https://reqres.in/api/users?page=2",200);

    }

    @Test
    public void post()
    {
        a.PostApi( "application/json","{\r\n"
                        + "    \"name\": \"morpheus\",\r\n"
                        + "    \"job\": \"leader\"\r\n"
                        + "}",201,"https://reqres.in/api/users");

    }

    @Test
    public void delete()
    {
    a.deleteApi("https://reqres.in/api/users/2",204);

    }

    @Test
    public void JsonString()
    {
        a.JsonPost("kawal","engineer","https://reqres.in/api/users",201);

    }


}
