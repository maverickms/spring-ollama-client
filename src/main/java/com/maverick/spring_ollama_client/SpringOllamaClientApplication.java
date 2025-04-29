package com.maverick.spring_ollama_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOllamaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOllamaClientApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ChatClient.Builder chatClientBuilder) {
		return args -> {
			var chatClient = chatClientBuilder.build();

			var response = chatClient.prompt()
					.user("What is 3+3?")
					.call()
					.content();

			System.out.println(response);
		};
	}
}