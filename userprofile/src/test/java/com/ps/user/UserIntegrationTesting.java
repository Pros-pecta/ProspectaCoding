package com.ps.user;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.Application;
import com.ps.model.User;

/*@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
@DisplayName("PRODUCT TEST SERVICE WITH INTEGRATION")
*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTesting  {


    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:"+port;
    }

    @Test
    @Order(2)
    @Disabled
    public void TestUsers() {

        HttpHeaders headers=new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<String>(null,headers);
        ResponseEntity<String> resp=restTemplate.exchange(getRootUrl()+ "/user", HttpMethod.GET,entity,String.class);

        System.out.println("Response Code::"+resp.getStatusCodeValue());
        System.out.println("Response Body::"+resp.getBody());
        
		/*  assertEquals(HttpStatus.OK.value(), resp.getStatusCodeValue());*/
        assertNotNull(resp.getBody());
    }
    
    //2.get Product by Id
    @Test
    @Order(3)
    @Disabled
    public void testUser() {
        User user=restTemplate.getForObject(getRootUrl() + "/user/1", User.class);
        System.out.println(user.getFirstName());
        assertNotNull(user);
    }

    //3.Save data to the Save

	@Test
    @Order(1)
	@Disabled
    public void saveProductData() throws JsonProcessingException {

        	    User user=new User();
	    	   user.setAddress("MVP COLONY");
	    	   user.setEmail("javed12@gmail.com");
	    	   user.setFirstName("Javed");
	    	   user.setLastName("Khan");
	    	   user.setDob("2021-04-12");
	    	
         ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/user", user, User.class);
           
         int status=postResponse.getStatusCodeValue();
         User resultUser=postResponse.getBody();
         System.out.println(postResponse.getBody());
         
         //verifiy
         assertEquals(HttpStatus.CREATED.value(), status);
         assertNotNull(resultUser);
         assertNotNull(resultUser.getId().longValue());

        }

        
            @Test
            @Order(4)
            @Disabled
    @DisplayName("Update method Testing")
    public void UpdateProductData() throws JsonProcessingException {

      User user=new User();

      User users=restTemplate.getForObject(getRootUrl() + "/user/1",User.class);

        System.out.println("the get DAta is here::"+user);

        user.setId(1);
 	   user.setAddress("MVP COLONY");
 	   user.setEmail("javed@gmail.com");
 	   user.setFirstName("Javed");
 	   user.setLastName("Khan");
 	   user.setDob("2021-04-12");

         restTemplate.put(getRootUrl() + "/user" , user, User.class);
         

    User userUpdate=restTemplate.getForObject(getRootUrl() + "/user/1", User.class);
    System.out.println("Data is her:::"+userUpdate);
        assertNotNull(userUpdate);
     
}



 @Test
 @Order(5)
 @Disabled
    public void testDeleteEmployee() {
     
         User user = restTemplate.getForObject(getRootUrl() + "/user/4" , User.class);
         assertNotNull(user);
         restTemplate.delete(getRootUrl() + "/employees/4");
         try {
              user = restTemplate.getForObject(getRootUrl() + "/employees/4", User.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }




}
