package com.groupeangular.projet1.entity.message;

import java.time.ZonedDateTime;

public class Message {

	private String emitter;
	private String topic;
	private String payload;
	private ZonedDateTime date;
	
	
	public Message(String emitter, String topic, String payload) {
		this.emitter = emitter;
		this.topic = topic;
		this.payload = payload;
		this.date = ZonedDateTime.now();
	}


	public String getEmitter() {
		return emitter;
	}

	public String getTopic() {
		return topic;
	}

	public String getPayload() {
		return payload;
	}
	
	public ZonedDateTime getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		
		builder.append("\"emitter\":\"");
		builder.append(this.emitter);
		builder.append("\", ");

		builder.append("\"topic\":\"");
		builder.append(this.topic);
		builder.append("\", ");

		builder.append("\"payload\":\"");
		builder.append(this.payload);
		builder.append("\", ");

		builder.append("\"date\":\"");
		builder.append(this.date.toString());
		builder.append("\", ");
		
		builder.append("}");
		
		return builder.toString();
	}
	
}
