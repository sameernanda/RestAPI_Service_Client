package org.calsoft.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.calsoft.rest.messenger.database.DatabaseClass;
import org.calsoft.rest.messenger.model.Message;

public class MessageService {

public MessageService(){
	messages.put(1L, new Message(1,"Sam","Hello SAM"));
	messages.put(2L, new Message(2,"Adi","Hi ADDI"));
}


	private Map<Long,Message> messages = DatabaseClass.getMessages();


	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage (Long id){
		return messages.get(id);
	}

	public Message addMessage (Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage (Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage (long id){
		return messages.remove(id);
	}
}
