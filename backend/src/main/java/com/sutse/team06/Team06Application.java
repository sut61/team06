package com.sutse.team06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sutse.team06.Repository.ClientRepository;
import com.sutse.team06.Repository.InsurancePriceRepository;
import com.sutse.team06.Repository.InsuranceTypeRepository;
import com.sutse.team06.Repository.*;
import com.sutse.team06.entity.*;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class Team06Application {

	public static void main(String[] args) {
		SpringApplication.run(Team06Application.class, args);
	}
	@Bean
	ApplicationRunner init(	ClientRepository clientRepository,
							InsuranceTypeRepository insurancetypeRepository,
							InsurancePriceRepository insurancepriceRepository,
							DeliveryCompanyRepository deliveryCompanyRepository,
							EmployeeRepository employeeRepository,
							HouseRepository houseRepository,
							RentHouseTypeRepository rentHouseTypeRepository,
							RentHouseRepository rentHouseRepository,
							FoodListRepository foodListRepository,
							RepairsRepository repairsRepository,
							EquipmentRepository equipmentRepository

							){

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
				InsuranceType type = new InsuranceType();
				type.setType(Type_of_insuance);
				insurancetypeRepository.save(type);
				if(Type_of_insuance=="Car"){
					InsuranceType insuType = insurancetypeRepository.findByType(Type_of_insuance);
					InsurancePrice insurancePrice1 = new InsurancePrice();
					insurancePrice1.setPrice(3000);
					insurancePrice1.setType(insuType);
					insurancepriceRepository.save(insurancePrice1);
					InsurancePrice insurancePrice2 = new InsurancePrice();
					insurancePrice2.setPrice(5500);
					insurancePrice2.setType(insuType);
					insurancepriceRepository.save(insurancePrice2);
					InsurancePrice insurancePrice3 = new InsurancePrice();
					insurancePrice3.setPrice(11000);
					insurancePrice3.setType(insuType);
					insurancepriceRepository.save(insurancePrice3);
					insurancetypeRepository.save(type);
				} 
				else if(Type_of_insuance=="Motorcycle"){

					InsuranceType insuType = insurancetypeRepository.findByType(Type_of_insuance);
					InsurancePrice insurancePrice1 = new InsurancePrice();
					insurancePrice1.setPrice(1500);
					insurancePrice1.setType(insuType);
					insurancepriceRepository.save(insurancePrice1);
					InsurancePrice insurancePrice2 = new InsurancePrice();
					insurancePrice2.setPrice(2750);
					insurancePrice2.setType(insuType);
					insurancepriceRepository.save(insurancePrice2);
					InsurancePrice insurancePrice3 = new InsurancePrice();
					insurancePrice3.setPrice(5500);
					insurancePrice3.setType(insuType);
					insurancepriceRepository.save(insurancePrice3);
					insurancetypeRepository.save(type);
				}
				else if(Type_of_insuance=="Bike"){

					InsuranceType insuType = insurancetypeRepository.findByType(Type_of_insuance);
					InsurancePrice insurancePrice1 = new InsurancePrice();
					insurancePrice1.setPrice(750);
					insurancePrice1.setType(insuType);
					insurancepriceRepository.save(insurancePrice1);
					InsurancePrice insurancePrice2 = new InsurancePrice();
					insurancePrice2.setPrice(1375);
					insurancePrice2.setType(insuType);
					insurancepriceRepository.save(insurancePrice2);
					insurancetypeRepository.save(type);
					
				}
				else if(Type_of_insuance=="Labtop"){

					InsuranceType insuType = insurancetypeRepository.findByType(Type_of_insuance);
					InsurancePrice insurancePrice1 = new InsurancePrice();
					insurancePrice1.setPrice(2000);
					insurancePrice1.setType(insuType);
					insurancepriceRepository.save(insurancePrice1);
					InsurancePrice insurancePrice2 = new InsurancePrice();
					insurancePrice2.setPrice(3950);
					insurancePrice2.setType(insuType);
					insurancepriceRepository.save(insurancePrice2);
					InsurancePrice insurancePrice3 = new InsurancePrice();
					insurancePrice3.setPrice(7900);
					insurancePrice3.setType(insuType);
					insurancepriceRepository.save(insurancePrice3);
					insurancetypeRepository.save(type);
				}  
			});
			Stream.of("Thailand Post", "Kerry Express", "SCG Express", "TNT","DHL Express").forEach(delivername ->{
				  DeliveryCompany deliver = new DeliveryCompany();
				  deliver.setName(delivername);
				  deliveryCompanyRepository.save(deliver);
			});
				Employee emp = new Employee();
				emp.setName("emp");
				emp.setUsername("admin");
				emp.setPassword("admin"); 
				employeeRepository.save(emp);
			
				//House
				Stream.of(1111,2222,3333,4444).forEach(houseNumber ->{
					House house = new House();	
					house.setHouseNumber(houseNumber);
					houseRepository.save(house);
				});

				//RentHouseType
				Stream.of("1 day","3 days","1 month","3 months").forEach(description ->{
					RentHouseType rentHouseType = new RentHouseType();
					rentHouseType.setDescription(description);
					rentHouseTypeRepository.save(rentHouseType);
				});

				//RentHouse
					RentHouse rentHouse = new RentHouse();
					rentHouse.setHouse(houseRepository.getOne(2L));
					rentHouse.setRentHouseType(rentHouseTypeRepository.getOne(3L));
					rentHouse.setResident("Jump");
					rentHouse.setEmployee(employeeRepository.getOne(1L));
					rentHouseRepository.save(rentHouse);

				//FoodList
				Stream.of("ข้าวกะเพราไก่","ข้าวกะเพราหมู","ข้าวกะเพรากุ้ง","ข้าวกะเพราเป็ด","ข้าวกะเพราทะเลรวมมิตร").forEach(foodlistName ->{
					FoodList foodList = new FoodList();
					foodList.setFoodlistName(foodlistName);
					foodListRepository.save(foodList);
				});

			

				//Equipment
				Stream.of("เตียง","โคมไฟ","ประตู","หน้าต่าง").forEach(equipmentlist ->{
					Equipment equipment = new Equipment();
					equipment.setEquipmentName(equipmentlist);
					// equipment.setHouse(houseRepository.getOne(1L));
					// equipment.setRepairs(null);
					equipmentRepository.save(equipment);
				});


		};
	}
	
}