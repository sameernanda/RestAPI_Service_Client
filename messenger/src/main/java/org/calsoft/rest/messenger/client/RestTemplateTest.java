package org.calsoft.rest.messenger.client;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.calsoft.rest.messenger.model.Message;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class RestTemplateTest {

	String url = "http://localhost:8080/messenger/webapi/messages";
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	static {
		DisableSSLVerification.disable();
	}
	
	public void  getMessage(){
		try {
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET, entity, String.class);
			System.out.println(response.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void  createMessage(){
		try {
			headers.setContentType(MediaType.APPLICATION_JSON);
			Message msg = new Message();
			msg.setAuthor("Sag");
			msg.setMessage("Sagar Here");
			HttpEntity<Message> entity = new HttpEntity<Message>(msg,headers);
			ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.POST, entity, String.class);
			System.out.println(response.getBody());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void  updateMessage(){
		try {
			String urlForPut = "http://localhost:8080/messenger/webapi/messages/{id}";
			headers.setContentType(MediaType.APPLICATION_JSON);
			Map<String,String> param = new HashMap<String,String>();
			param.put("id","3");
			Message msg = new Message();
			msg.setAuthor("Sag");
			msg.setMessage("Sagar Kumar Nanda");
			HttpEntity<Message> entity = new HttpEntity<Message>(msg,headers);
			ResponseEntity<String> response = restTemplate.exchange(urlForPut,HttpMethod.PUT, entity, String.class,param);
			System.out.println(response.getBody());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		RestTemplateTest rTest = new RestTemplateTest();
		rTest.getMessage();
		System.out.println("######################################################################################################################");
		rTest.createMessage();
		System.out.println("######################################################################################################################");
		rTest.updateMessage();
		System.out.println("######################################################################################################################");
		rTest.getMessage();
	}
}