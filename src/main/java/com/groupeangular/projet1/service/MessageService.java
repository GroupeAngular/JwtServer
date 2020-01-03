package com.groupeangular.projet1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.groupeangular.projet1.entity.message.Message;

public class MessageService {

	private static final Map<String, List<Message>> messages = new HashMap<>();
	
	
	public void addMessage(Message newMessage) {
		List<Message> topicMessages = MessageService.messages.get(newMessage.getTopic());
		
		if(topicMessages == null) {
			// Create new topic
			topicMessages = new ArrayList<>();
			
			// Add it to global map
			MessageService.messages.put(newMessage.getTopic(), topicMessages);
		}

		// Add message
		topicMessages.add(newMessage);
	}
	
	public Optional<List<Message>> getMessages(String topic) {
		List<Message> topicMessage = MessageService.messages.get(topic);
		
		return (topicMessage == null ? Optional.empty() : Optional.of(topicMessage));
	}
	
}
