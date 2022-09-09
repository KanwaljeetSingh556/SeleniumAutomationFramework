package com.qa.opencart.pages;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;


public class ProjectTest
{

    public static void main(String[] args) throws SerializeException, ParseException {
        JsonSerializer jsonSerializer =  JsonSerializer.DEFAULT_READABLE;

        String[] sellerNames = {"Neon Enterprise", "ABC Software" , ""};
        Product product = new Product("MAcbookPro", 1000,"White",sellerNames);

       String json =  jsonSerializer.serialize(product);
     //  System.out.println(json);

        XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        String xmlString = xmlSerializer.serialize(product);
       // System.out.println(xmlString);

        HtmlSerializer htmlSerializer = HtmlSerializer.DEFAULT_SQ_READABLE;
        String html = htmlSerializer.serialize(product);
        //System.out.println(html);

        //desearilization
        JsonParser jsonParser = JsonParser.DEFAULT;
        String jsonVal = "{\n" +
                " \"color\": \"White\",\n" +
                " \"name\": \"MAcbookPro\",\n" +
                " \"price\": 1000,\n" +
                " \"sellerNames\": [\n" +
                " \"Neon Enterprise\",\n" +
                " \"ABC Software\",\n" +
                "\"XYZ IT Solutions\"\n" +
                " ]\n" +
                "}";


             Product pro =    jsonParser.parse(jsonVal,Product.class);
        System.out.println(pro.getColor());




    }
}
