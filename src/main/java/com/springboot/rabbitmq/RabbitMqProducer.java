package com.springboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {

	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMsg(String msg) {
		rabbitTemplate.convertAndSend(RabbitMqConfig.exchangeName, RabbitMqConfig.routingKey, msg);
	}
	
	
}
