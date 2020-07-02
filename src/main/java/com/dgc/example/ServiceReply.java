package com.dgc.example;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ServiceReply {

//	@KafkaListener(topics = "${kafka.reuest.topic}", groupId = "${kafka.group.id}")
	@KafkaListener( topics = "#{consumerContext.getTopics()}", groupId = "${kafka.group.id}")
	@SendTo
	public Result handle(Result request, Acknowledgment ack) {
		double total = ThreadLocalRandom.current().nextDouble(2.5, 9.9);
		Result result = new Result();
		result.setId(UUID.randomUUID());
		result.setValue(String.valueOf(total * 10).substring(0, 4) + "%");
		return result;
	}
}