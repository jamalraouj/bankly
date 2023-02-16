package com.user.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class UserApplication {
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
		SpringApplication.run(UserApplication.class, args);
	}

}
