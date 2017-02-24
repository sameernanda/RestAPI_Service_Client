package org.calsoft.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.calsoft.rest.messenger.model.Message;
import org.calsoft.rest.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messgaeService = new MessageService();


	@GET
	public List<Message> getMessages(){
		return messgaeService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId){
		return messgaeService.getMessage(messageId);
	}

	@POST
	public Message addMessage(Message message){
		return messgaeService.addMessage(message);

	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long messageId,Message message){
		message.setId(messageId);
		return messgaeService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long messageId){
		messgaeService.removeMessage(messageId);
	}
}
