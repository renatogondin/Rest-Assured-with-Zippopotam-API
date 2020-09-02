package renato;

import static io.restassured.RestAssured.*;

//import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class SpringBootBackEndTest {
	
	
	//https://github.com/renatogondin/spring-ionic-backend
	//requests sent to localhost:8080
	
	
	
	
	//checking token
	
	@Test
	public void checkOAuthAuthentication() {
		given()
		    .auth()
		//Due to security concerns, I won't commit the real token here
		     .oauth2("myToken")
		.when()
		     .get("http://localhost:8080/auth")
		.then()
			 .assertThat()
		     .statusCode(200);
	}
	
	@Test
	public void checkPostMethod() {
		
		  String corpo = "{ 'cliente' : '1, 'desconto' : 0.0 , 'produto : '2'}";
		
		given()
		   .body(corpo)
		.when()
		    .post("localhost:8080/pedidos")
		.then()
		.assertThat().statusCode(201);
	}
	@Test
	public void checkPutMethod() {
		
		  String corpo = "{ 'cliente' : '2', 'desconto' : 0.0 , 'produto : '2'}";
		
		given()
			.pathParam("idPath", "1")
		   .body(corpo)
		.when()
		    .post("localhost:8080/pedidos/{idPath}")
		.then()
		.assertThat().statusCode(204);
	}
	

}
