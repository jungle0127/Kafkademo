package com.ps.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ps.kafkademo.dto.Message;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Producer producer = context.getBean(Producer.class);
		 
	    for (int i = 1; i < 10; i++) {
	      producer.send("test_topic", new Message(i, "test topic message " + i));
	      Thread.sleep(2000);
	    }
		
	}
}
