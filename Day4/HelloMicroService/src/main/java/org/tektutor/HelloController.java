package org.tektutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloController {

	@Autowired
	private MessageRepository messageRepository;

	@GetMapping("hello")
	public @ResponseBody Iterable<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public static void main( String[] args ) {
		SpringApplication.run ( HelloController.class, args );
	}

}
