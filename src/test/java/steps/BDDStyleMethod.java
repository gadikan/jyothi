package steps;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static utilities.RestAssuredExtention.*;

public class BDDStyleMethod {
    public static void getSimplePost(String postNumber) {
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().
                body("author", is("Vinayak"))
                .statusCode(200);
    }

    public static void performContainsCollection(){
        given()
                .contentType(ContentType.JSON).
                when()
                .get("http://localhost:3000/posts/").
                then()
                .body("author",containsInAnyOrder("Vinayak","Angel","Koli","Josh",null))
                .statusCode(200);
    }

    public static void performPathParameter(String postNumber, String authorName){
        given()
                .contentType(ContentType.JSON).
                with()
                .pathParams("post",postNumber).
                when()
                .get("http://localhost:3000/posts/{post}").
                then()
                .body("author",containsStringIgnoringCase(authorName));
    }

    public static void performQueryParameter(){
        given()
                .contentType(ContentType.JSON).
                with().
                queryParam("_page","1").queryParam("_limit","2").
                when()
                .get("http://localhost:3000/posts/").
                then()
                .body("author",hasSize(2));
    }
    public static void performBodyParamerter(){

        Map<String,String> authentication = new HashMap<String,String>();
        authentication.put("email","vinayak.koli@gmail,com");
        authentication.put("password","password1234");
        given()
                .contentType(ContentType.JSON).
                with().
                body(authentication).
                when()
                .get("http://localhost:3000/auth/login").
                then()
                .body("access_token",notNullValue());
    }

    public static void getOpsWithPathParam(){

    }
}

