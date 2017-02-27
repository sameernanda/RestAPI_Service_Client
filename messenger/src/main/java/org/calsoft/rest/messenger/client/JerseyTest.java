package org.calsoft.rest.messenger.client;
import javax.ws.rs.core.MediaType;
import org.calsoft.rest.messenger.model.Message;
import org.codehaus.jackson.map.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
public class JerseyTest {
	String url = "http://localhost:8080/messenger/webapi/messages";
	Client client = Client.create();

	static {
		DisableSSLVerification.disable();
	}

	public void  getMessage(){
		try {
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			System.out.println(response.getEntity(String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  createMessage(){
		try {
			WebResource webResource = client.resource(url);
			Message msg = new Message();
			msg.setAuthor("Sag");
			msg.setMessage("Sagar Here");
			ObjectMapper mapper = new ObjectMapper();
			String requestEntity = mapper.writeValueAsString(msg);
			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).header("Content-type", MediaType.APPLICATION_JSON).post(ClientResponse.class,requestEntity);
			System.out.println(response.getEntity(String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  updateMessage(String id){
		try {
			WebResource webResource = client.resource(url).path(id);
			Message msg = new Message();
			msg.setAuthor("Sag");
			msg.setMessage("Sagar Kumar Nanda");
			ObjectMapper mapper = new ObjectMapper();
			String requestEntity = mapper.writeValueAsString(msg);
			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).header("Content-type", MediaType.APPLICATION_JSON).put(ClientResponse.class,requestEntity);
			System.out.println(response.getEntity(String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JerseyTest jTest = new JerseyTest();
			jTest.getMessage();
			System.out.println("######################################################################################################################");
			jTest.createMessage();
			System.out.println("######################################################################################################################");
			jTest.updateMessage("3");
			System.out.println("######################################################################################################################");
			jTest.getMessage();
	}
}
