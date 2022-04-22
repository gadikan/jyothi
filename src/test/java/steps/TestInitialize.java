
package steps;

       // import cucumber.api.java.Before;
        import io.cucumber.java.Before;
        import org.testng.annotations.Test;
        import utilities.RestAssuredExtention;

public class TestInitialize {

    @Before
    public static void testSetup() {
        RestAssuredExtention restAssuredExtention = new RestAssuredExtention();
    }
}
