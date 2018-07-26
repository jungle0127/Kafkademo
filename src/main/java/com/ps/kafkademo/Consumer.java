package com.ps.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ps.kafkademo.dto.Message;

@Component
public class Consumer {
	private final static Logger logger = LoggerFactory.getLogger(Consumer.class);
	@KafkaListener(topics = "test_topic")
	public void receive(ConsumerRecord<String, Message> consumerRecord) {
		logger.info("Consumer->topic:{}, value:{}", consumerRecord.topic(), consumerRecord.value());
	}

}
