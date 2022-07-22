package com.tutorial.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

		/*@Bean
    CommandLineRunner run(ClientService clientService){
        return args -> {
            //clientService.addClient(new Client(null,"Ada",0, "123456",null,null));
            //clientService.addClient(new Client(null,"Richard",0, "123456",null,null));
            //clientService.addClient(new Client(null,"Steve",0, "123456",null,null));

            //clientService.saveRole(new Role(null, "ROLE_USER"));
            //clientService.saveRole(new Role(null, "ROLE_ADMINISTRATOR"));
            //clientService.saveRole(new Role(null, "ROLE_MANAGER"));

            //clientService.addRoleToClient("Richard", "ROLE_USER");
            //clientService.addRoleToClient("Richard", "ROLE_MANAGER");
            //clientService.addRoleToClient("Ada", "ROLE_ADMINISTRATOR");
        };
    }*/

}
