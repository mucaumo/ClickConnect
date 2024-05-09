package br.com.fiap.clickconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "ClickConnect API",
		version = "1.0",
		contact = @Contact(name = "Lucas Lima", email = "lucaslima@gmail.com"),
		license = @License(name = "MIT", url = "https://opensource.org/license/mit"),
		summary = "API do app ClickConnect - site de vendas de periféricos"
	)
)
public class ClickConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickConnectApplication.class, args);
	}


}
