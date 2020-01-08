package com.groupeangular.projet1.websocket;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupeangular.projet1.entity.User;
import com.groupeangular.projet1.entity.message.Message;
import com.groupeangular.projet1.service.UserService;

@Component
public class WebSocketEndpoint extends TextWebSocketHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEndpoint.class);
	
	@Autowired
	private WebSocketSessionHandler wsSessionHandler;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Optional<User> optional = userService.findByUsername(session.getPrincipal().getName());
		if(optional.isPresent()) {
			wsSessionHandler.connectSession(optional.get().getId(), session);
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Optional<User> optional = userService.findByUsername(session.getPrincipal().getName());
		if(optional.isPresent()) {
			wsSessionHandler.disconnectSession(optional.get().getId());
		}
	}
	
	public void sendMessage(Message message) {
		WebSocketSession session = wsSessionHandler.getSession(message.getReceiverId());
		try {
			String messagePayload = new ObjectMapper().writeValueAsString(message);
			sendMessage(session, messagePayload);
		} catch (JsonProcessingException e) {
			logger.error("failed to parse message");
		}
	}
	
	private void sendMessage(WebSocketSession session, String messagePayload) {
		if(session != null && session.isOpen()) {
			try {
				session.sendMessage(new TextMessage(messagePayload));
			} catch (IOException e) {
				logger.error("Error while sending message to session " + session.getId(), e);
			}
		} else if(session != null) {
			logger.error("Session {} already closed. Cannot send the message", session.getId());
		} else {
			logger.error("Session doesn't exist. Cannot send the message");
		}
	}

}
