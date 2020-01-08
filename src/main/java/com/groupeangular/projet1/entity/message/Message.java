package com.groupeangular.projet1.entity.message;

import java.time.ZonedDateTime;

public class Message {

	private Long emitterId;
	
	private Long receiverId;
	
	private String payload;
	
	private ZonedDateTime date;
	
	public Long getEmitterId() {
		return emitterId;
	}

	public void setEmitterId(Long emitterId) {
		this.emitterId = emitterId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		
		builder.append("\"emitter\":\"");
		builder.append(this.emitterId);
		builder.append("\", ");

		builder.append("\"receiver\":\"");
		builder.append(this.receiverId);
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
