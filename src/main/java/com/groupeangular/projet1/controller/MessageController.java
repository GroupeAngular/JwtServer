package com.groupeangular.projet1.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupeangular.projet1.entity.message.Message;
import com.groupeangular.projet1.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;

	
	@PostMapping
	public ResponseEntity<Void> addMessage(@RequestBody Message message) {
		logger.info("New message recieved : {}", message);
		
		this.messageService.addMessage(message);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("{topic}")
	public ResponseEntity<List<Message>> getMessages(@PathVariable String topic) {
		return new ResponseEntity<>(this.messageService.getMessages(topic)
						.orElse(new ArrayList<>()), HttpStatus.OK);
	}
}
