package com.ps.kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ps.kafkademo.dto.Message;

@Component
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
  @Autowired
  private KafkaTemplate<?, Message> kafkaTemplate;
 
  public void send(String topic, Message message) {
    kafkaTemplate.send(topic, message);
    logger.info("Producer->topic:{}, message:{}", topic, message);
  }
 
}