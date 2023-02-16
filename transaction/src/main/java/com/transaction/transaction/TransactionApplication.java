package com.transaction.transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.transaction.transaction.proxy")
public class TransactionApplication {
//	@Bean
//	public Decoder decoder(ObjectMapper objectMapper) {
//		return new JacksonDecoder(objectMapper);
//	}
//
//	@Bean
//	public Encoder encoder(ObjectMapper objectMapper) {
//		return new JacksonEncoder(objectMapper);
//	}
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
