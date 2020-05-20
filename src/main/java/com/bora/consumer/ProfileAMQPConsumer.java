package com.bora.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bora.consumer.config.ProfileAMQPConfig;
import com.bora.consumer.model.Message;
import com.bora.consumer.repository.ProfileAMQPRepository;

@Component
public class ProfileAMQPConsumer {

	private static final Logger logger = LoggerFactory.getLogger(ProfileAMQPConsumer.class);

	@Autowired
	private ProfileAMQPRepository repository;

	@RabbitListener(queues = ProfileAMQPConfig.QUEUE)
	public void consumer(Message message) {
		logger.info("Consumindo mensagem da fila...");

		Message m = new Message(message.getMessage());
		repository.save(m);
	}
}
