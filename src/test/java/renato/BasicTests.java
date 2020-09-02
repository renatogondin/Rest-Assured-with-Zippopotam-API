package renato;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;



import org.junit.Test;

public class BasicTests {
	
	
	
	
	
	
	//checking place name
	
	@Test
	public void getUsZipCode90210_checkTheNameInResponseBody_expectedBerverlyHills() {
		given().
		
		when()
		    .get("http://api.zippopotam.us/us/90210")
		.then()
		    .assertThat().body("places[0].'place name'", equalTo("Beverly Hills") );
	}
	
	//checking response and also testing if are we calling 
	//for California
	
	@Test
	public void getUsZipCode90210_receive200msgok() {
		given().
		when().
		    get("http://api.zippopotam.us/us/90210").
		then().
		assertThat().body("places[0].'state'", equalTo("California")).
		and().
		assertThat().
		statusCode(200);
	}
	
	//check if we are receiving json back
	
	@Test
	public void getContentTypeAsJson() {
		given()
		.when()
		    .get("http://api.zippopotam.us/us/90210")
		.then()
		.assertThat()
		.contentType("application/json");
		
	}
	
	//checking a get with a complete log
	@Test
	public void getCompleteLogBody() {
		given().
		//busca o log todo
		log().all()
		.when()
		.get("http://api.zippopotam.us/us/90210")
		.then()
		.log().body();
	}
	
	//check if they have Beverly Hills in the API
	
	@Test
	public void getCheckiftheyhaveBeverlyHillsThere() {
		given()
		.when()
		    .get("http://api.zippopotam.us/us/90210")
		.then()
		.assertThat().body("places.'place name'", hasItem("Beverly Hills"));
	}
	
	//check if our web api is sending to the exact zip code. Try White House
	
	@Test
	public void getCheckifourapiissendingtorealzipcode() {
		given()
		.when()
		    .get("http://api.zippopotam.us/us/37188")
		.then()
		     .assertThat().body("places[0].'place name'", equalTo("White House"));
		
		
	}
	
	//method giving back USA as a country
	
	@Test
	public void getCheckIfUsaIsGivenBack() {
		given()
		.when()
		    .get("http://api.zippopotam.us/us/37188")
		.then()
		.assertThat().body("country", equalTo("United States"));
	}
	
	//using PathParams
	
	@Test
	public void usingPathParams() {
		given()
		    .pathParam("oneParam", "us")
		    .pathParam("otherParam", "90210")
		.when()
		    .get("http://api.zippopotam.us/{oneParam}/{otherParam}")
		.then()
		.assertThat().body("country", equalTo("United States"));
	}
	
	
		

}
