package com.springboot.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
	
	public static final String queueName="new queue";
	public static final String exchangeName="new exchange";
	public static final String routingKey="new key";

	
	
	@Bean
	Queue queue() {
		return new Queue(queueName);
	}
	
	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(exchangeName);
	}
	
	@Bean
	Binding binding() {
		return BindingBuilder
				.bind(queue())
				.to(topicExchange())
				.with(routingKey);
	}
	
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		 return new RabbitTemplate(connectionFactory);
	}
	
}
