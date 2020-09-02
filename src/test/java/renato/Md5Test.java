package renato;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class Md5Test {
	
	
	
	@Test
	public void useQueryParameter() {
		given()
		.queryParam("text", "testcase")
		.when().get("http://md5.jsontest.com")
		    .then()
		    		.assertThat().body("md5", equalTo("7489a25fc99976f06fecb807991c61cf"));
	}
	

}
