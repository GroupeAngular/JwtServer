package com.groupeangular.projet1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupeangular.projet1.entity.message.Message;
import com.groupeangular.projet1.websocket.WebSocketEndpoint;

@Service
public class MessageService {

	private Map<String, List<Message>> messages = new HashMap<>();
	
	@Autowired
	private WebSocketEndpoint wsEndpoint;
	
	public void sendMessage(Message newMessage) {
		String topic = newMessage.getEmitterId() + "-" + newMessage.getReceiverId();
		messages.computeIfAbsent(topic, t -> new ArrayList<Message>());
		messages.get(topic).add(newMessage);
		wsEndpoint.sendMessage(newMessage);
	}

	public Optional<List<Message>> getMessages(String topic) {
		List<Message> topicMessage = this.messages.get(topic);
		return (topicMessage == null ? Optional.empty() : Optional.of(topicMessage));
	}

}
