package com.sutse.team06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sutse.team06.entity.*;

import java.util.stream.Stream;

import com.sutse.team06.repository.*;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class Team06Application {

	public static void main(String[] args) {
		SpringApplication.run(Team06Application.class, args);
	}
	@Bean
	ApplicationRunner init(ClientRepository clientRepository,TypeRepository typeRepository,PriceRepository priceRepository){

		return args ->{

			//Client
			Stream.of("Best","Jump").forEach(Name ->{
				Client client = new Client();
				client.setName(Name);
				if(Name=="Best"){
					client.setUsername("Test1");
					client.setPassword("Test1");
				}
				if(Name=="Jump"){
					client.setUsername("Test2");
					client.setPassword("Test2");
				}
				clientRepository.save(client);	
			});
			//type
			Stream.of("Car","Motorcycle","Bike","Labtop").forEach(Type_of_insuance ->{
				Type type = new Type();
				type.setType(Type_of_insuance);
				typeRepository.save(type);
				Price price = new Price();
				if(Type_of_insuance=="Car"){
					price.setPrice1("3000 bath / 3 months");
					price.setPrice2("5500 bath / 6 months");
					price.setPrice3("11000 bath / 12 months");
					price.setType(typeRepository.getOne(1L));
					typeRepository.save(type);
					priceRepository.save(price);
				} 
				else if(Type_of_insuance=="Motorcycle"){
					price.setPrice1("1500 bath / 3 months");
					price.setPrice2("2750 bath / 6 months");
					price.setPrice3("5500 bath / 12 months");
					price.setType(typeRepository.getOne(2L));
					typeRepository.save(type);
					priceRepository.save(price);
				}
				else if(Type_of_insuance=="Bike"){
					price.setPrice1("750 bath / 3 months");
					price.setPrice2("1375 bath / 6 months");
					price.setPrice3("-");
					price.setType(typeRepository.getOne(3L));
					typeRepository.save(type);
					priceRepository.save(price);
				}
				else if(Type_of_insuance=="Labtop"){
					price.setPrice1("2000 bath / 3 months");
					price.setPrice2("3950 bath / 6 months");
					price.setPrice3("7900 bath / 12 months");
					price.setType(typeRepository.getOne(4L));
					typeRepository.save(type);
					priceRepository.save(price);
				}  
				priceRepository.save(price);
			});
				
			
		};
	}
	
}