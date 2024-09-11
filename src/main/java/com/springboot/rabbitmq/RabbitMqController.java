package com.springboot.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RabbitMqController {
	
	@Autowired
	private RabbitMqProducer produce;
	
	@GetMapping("/send")
	public ResponseEntity<String> send(@RequestParam(name = "msg") String msg){
		
		produce.sendMsg(msg);
		
		return ResponseEntity.ok("done");
	}

}
