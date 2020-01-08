package com.groupeangular.projet1.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketSessionHandler {
	
	private Map<Long, WebSocketSession> sessions = new HashMap<>();
	
	public WebSocketSession getSession(Long id) {
		return this.sessions.get(id);
	}
	
	public void connectSession(Long id, WebSocketSession session) {
		this.sessions.put(id, session);
	}

	public void disconnectSession(Long id) {
		this.sessions.remove(id);
	}
	
}
