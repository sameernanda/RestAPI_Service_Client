package org.calsoft.rest.messenger.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

	static {
		DisableSSLVerification.disable();
	}

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = "http://localhost:8080/messenger/webapi/messages";
		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET, entity, String.class);
		System.out.println(response.getBody());
	}
}