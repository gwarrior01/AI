package club.twopages.dml;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(ChatClient.Builder builder) {
		return args -> {
			var client = builder.build();
			var res = client.prompt("Расскажи какой-нибудь факт про Kubernetes")
					.call()
					.content();
			System.out.println(res);
		};
	}
}
