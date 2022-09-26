package br.com.Consulta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient /*  registro do serviço de inicialização de primavera 
para alterar este ip para o endereço ip da máquina host, para que meu aplicativo seja registrado 
em eureka com o endereço ip host onde meu api está sendo executado
seria mais para fazer com que o aplicativo Spring Boot se registre no servidor de forma automatica
*/
public class ConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaApplication.class, args);
	}

}
