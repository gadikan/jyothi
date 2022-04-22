
package utilities;

        import io.restassured.RestAssured;
        import io.restassured.builder.RequestSpecBuilder;
        import io.restassured.http.ContentType;
        import io.restassured.response.Response;
        import io.restassured.response.ResponseOptions;
        import io.restassured.specification.RequestSpecification;
        import lombok.var;

        import java.net.URI;
        import java.net.URISyntaxException;
        import java.util.HashMap;
        import java.util.LinkedHashMap;
        import java.util.Map;
public class RestAssuredExtention {

    public static RequestSpecification Request;

    public RestAssuredExtention() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(ContentType.JSON);
        // builder.setBasePath("http://localhost:3000");
        builder.setBaseUri("http://localhost:3000");
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> getOps(String url) throws URISyntaxException {

        if (url != null) {
            try {
//                return request.get(new URI(url));
                return Request.get(new URI(url));
            } catch (URISyntaxException e) {
//            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("URL empty");
        }
        return null;
    }
    public static ResponseOptions<Response> PostWithScenarioOutline(String id,String title,String author){
        Map<String,Object> postBody=new LinkedHashMap<String,Object>();
        postBody.put("id",Integer.valueOf(id));
        postBody.put("title",title);
        postBody.put("author",author);
        Request.body(postBody);

        try {
            Response response= Request.post(new URI("http://localhost:3000/posts"));
            return response;

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static ResponseOptions<Response> getOpsWithPathPathParameter(String url, Map<String, String> pathParams) {
        Request.pathParams(pathParams);
        if (url == null) {
            try {
                return Request.get(new URI(url));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Empty url");
        }
        return null;
    }
}

