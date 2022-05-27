package com.example.patagoniatest;

import com.example.patagoniatest.repository.ClientRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatagoniaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatagoniaTestApplication.class, args);
        
        try{
            //Client cliente1= new ClientAbortException(throwable)
            //Client client1= new Client(id:1, fullName:"Andre", income:2 );
            //ClientRepository clientRepository;
            //ClientController client1= new ClientController.getClients(1,);
            Cliente cli = new Cliente();
            
            System.out.println(cli.getClient);
            }

            catch(IllegalStateException exception){
                System.out.println("el cliente con el id solicitado, no existe");
            }

            finally{
                System.out.println("Estamos en finally");
            }
            if(String fullName.equals(Integer income)){
                
            }
    }
    

}
