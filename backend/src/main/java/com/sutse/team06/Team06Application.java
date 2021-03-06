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
import java.util.*;
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
							EquipmentRepository equipmentRepository,
							CancelTypeRepository cancelTypeRepository,
							CanceledRentHouseRepository canceledRentHouseRepository,
							ElectricityAndWaterReceiptRepository electricityandwaterreceiptRepository,
							MounthRepository mounthRepository,
							TypeSpeedInternetRepository typeSpeedInternetRepository,
							TimeTypeUseRepository timeTypeUseRepository,
							ScaleTimeRepository scaleTimeRepository,
							TransportationCarRepository transportationCarRepository,
							CarRepository carRepository,
							PlaceRepository placeRepository,
							TypeHouseKeeperRepository typeHouseKeeperRepository,
							ManagePackageInRepository managePackageInRepository
							){

		return args ->{

			
			//InsuranceType
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
				//Stream.of(1111,2222,3333,4444).forEach(houseNumber ->{
				House house4 = new House();	
					house4.setHouseNumber(1111);
					house4.setStyle("ใหญ่โต");
					houseRepository.save(house4);

					House house1 = new House();	
					house1.setHouseNumber(2222);
					house1.setStyle("อลังการ");
					houseRepository.save(house1);

					House house2 = new House();	
					house2.setHouseNumber(3333);
					house2.setStyle("กระท่อม");
					houseRepository.save(house2);

					House house3 = new House();	
					house3.setHouseNumber(4444);
					house3.setStyle("ธรรมชาติ");
					houseRepository.save(house3); 

				//RentHouseType
				//Stream.of("1 day","3 days","1 month","3 months").forEach(description ->{
					RentHouseType rentHouseType1 = new RentHouseType();
					rentHouseType1.setDescription("1 day");
					rentHouseType1.setAdditional("none");
					rentHouseTypeRepository.save(rentHouseType1);

					RentHouseType rentHouseType2 = new RentHouseType();
					rentHouseType2.setDescription("3 days");
					rentHouseType2.setAdditional("welcome drink");
					rentHouseTypeRepository.save(rentHouseType2);

					RentHouseType rentHouseType3 = new RentHouseType();
					rentHouseType3.setDescription("1 month");
					rentHouseType3.setAdditional("free 1 meal");
					rentHouseTypeRepository.save(rentHouseType3);

					RentHouseType rentHouseType4 = new RentHouseType();
					rentHouseType4.setDescription("3 months");
					rentHouseType4.setAdditional("10 packs of candies");
					rentHouseTypeRepository.save(rentHouseType4);
				

				//RentHouse
					RentHouse rentHouse = new RentHouse();
					rentHouse.setHouse(houseRepository.getOne(2L));
					rentHouse.setRentHouseType(rentHouseTypeRepository.getOne(3L));
					rentHouse.setResident("Mr.Tomas");
					rentHouse.setEmployee(employeeRepository.getOne(1L));
					rentHouseRepository.save(rentHouse);

					RentHouse rentHouse1 = new RentHouse();
					rentHouse1.setHouse(houseRepository.getOne(3L));
					rentHouse1.setRentHouseType(rentHouseTypeRepository.getOne(4L));
					rentHouse1.setResident("Mr.Joseph");
					rentHouse1.setEmployee(employeeRepository.getOne(1L));
					rentHouseRepository.save(rentHouse1);

					RentHouse rentHouse2 = new RentHouse();
					rentHouse2.setHouse(houseRepository.getOne(4L));
					rentHouse2.setRentHouseType(rentHouseTypeRepository.getOne(1L));
					rentHouse2.setResident("Mrs.Susan");
					rentHouse2.setEmployee(employeeRepository.getOne(1L));
					rentHouseRepository.save(rentHouse2);

				//Client
			Stream.of("Best","Jump","A").forEach(Name ->{
				Client client = new Client();
				client.setName(Name);
				if(Name=="Best"){
					client.setUsername("Test1");
					client.setPassword("Test1");
					client.setRentHouse(rentHouseRepository.getOne(1L));
				}
				if(Name=="Jump"){
					client.setUsername("Test2");
					client.setPassword("Test2");
					client.setRentHouse(rentHouseRepository.getOne(2L));
				}
				if(Name=="A"){
					client.setUsername("Test3");
					client.setPassword("Test3");
					client.setRentHouse(rentHouseRepository.getOne(3L));
				}
				
				clientRepository.save(client);	
			});	

			//mounth
			Stream.of("January","February","March","April","May","June","July",
			"August","September","October","November","December").forEach(mounth ->{
				Mounth mounths = new Mounth();
				mounths.setMounth(mounth);
				// equipment.setHouse(houseRepository.getOne(1L));
				// equipment.setRepairs(null);
				mounthRepository.save(mounths);
			});

			//Electric and water
			ElectricityAndWaterReceipt ew1 = new ElectricityAndWaterReceipt();
			ew1.setElectricity(700);
			ew1.setWater(200);
			ew1.setCid(clientRepository.getOne(3L));
			ew1.setMid(mounthRepository.getOne(1L));
			ew1.setHouse(houseRepository.getOne(3L));
			ew1.setMeterchecker("dom");
			ew1.setSliptid("R11111");
			electricityandwaterreceiptRepository.save(ew1);
			
			ElectricityAndWaterReceipt ew2 = new ElectricityAndWaterReceipt();
			ew2.setElectricity(850);
			ew2.setWater(150);
			ew2.setCid(clientRepository.getOne(1L));
			ew2.setMid(mounthRepository.getOne(1L));
			ew2.setHouse(houseRepository.getOne(2L));
			ew2.setMeterchecker("bryan");
			ew2.setSliptid("R22222");
			electricityandwaterreceiptRepository.save(ew2);

				//FoodList
				Stream.of("ข้าวกะเพราไก่","ข้าวกะเพราหมู","ข้าวกะเพรากุ้ง","ข้าวกะเพราเป็ด","ข้าวกะเพราทะเลรวมมิตร").forEach(foodlistName ->{
					FoodList foodList = new FoodList();
					foodList.setFoodlistName(foodlistName);
					if (foodlistName=="ข้าวกะเพราไก่" || foodlistName=="ข้าวกะเพราหมู"){
						foodList.setFoodlistPrice(40);
					}
					else if(foodlistName=="ข้าวกะเพรากุ้ง" || foodlistName=="ข้าวกะเพราเป็ด"){
						foodList.setFoodlistPrice(50);
					}
					else{
						foodList.setFoodlistPrice(60);
					}
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

				//CancelType
				//("ครบสัญญา","ค้างชำระ","ยกเลิกก่อนกำหนด","อื่นๆ")
					CancelType cancel = new CancelType();
					cancel.setCanceltype("ครบสัญญา");
					cancel.setDescription("หมดสัญญาตามเวลา");
					cancel.setFinerate("10-25 bath");
					cancel.setTax(5);
					cancel.setMessage("Thank you");
					cancelTypeRepository.save(cancel);

					CancelType cancel1 = new CancelType();
					cancel1.setCanceltype("ค้างชำระ");
					cancel1.setDescription("มียอดค้างชำระเกินกำหนด");
					cancel1.setFinerate("80-95 bath");
					cancel1.setTax(7);
					cancel1.setMessage("pls be on time");
					cancelTypeRepository.save(cancel1);

					CancelType cancel2 = new CancelType();
					cancel2.setCanceltype("ยกเลิกก่อนกำหนด");
					cancel2.setDescription("ยุติสัญญาก่อนหมดอายุ");
					cancel2.setFinerate("20-25 bath");
					cancel2.setTax(5);
					cancel2.setMessage("Thanks");
					cancelTypeRepository.save(cancel2);

					CancelType cancel3 = new CancelType();
					cancel3.setCanceltype("อื่นๆ");
					cancel3.setDescription("นอกเหนือกรณีที่มีอยู่");
					cancel3.setFinerate("50-65 bath");
					cancel3.setTax(4);
					cancel3.setMessage("Thank you very much");
					cancelTypeRepository.save(cancel3);



				//new keng 
				typeSpeedInternetRepository.save(new TypeSpeedInternet("10/30 Mb",10));
				typeSpeedInternetRepository.save(new TypeSpeedInternet("30/50 Mb",1));
				typeSpeedInternetRepository.save(new TypeSpeedInternet("50/100 Mb",5));
				Stream.of("week","month").forEach(scaleTimeid ->{
					ScaleTime scaleTime = new  ScaleTime();
					scaleTime.setTypeScale(scaleTimeid);
					scaleTimeRepository.save(scaleTime);
					
				});
				ScaleTime scale1 = scaleTimeRepository.findByScaleTimeId(1L);
				ScaleTime scale2 = scaleTimeRepository.findByScaleTimeId(2L);

				for(int time = 1; time<=3; time++){
					TimeTypeUse timeuse = new  TimeTypeUse();
					timeuse.setTimeType(time);
					timeuse.setScaleTime(scale1);
					timeTypeUseRepository.save(timeuse);
				}
				for(int time = 1; time<=3; time++){
					TimeTypeUse timeuses = new  TimeTypeUse();
					timeuses.setTimeType(time);
					timeuses.setScaleTime(scale2);
					timeTypeUseRepository.save(timeuses);
				}
					Stream.of("Male","Female").forEach(keeper ->{
						TypeHouseKeeper keepers = new TypeHouseKeeper();
						keepers.setTypehouseKeeper(keeper);
						typeHouseKeeperRepository.save(keepers);
				});
					//Car
				Stream.of("Taxi","Hatchback","Sedan","SUV","Convertible").forEach(carType ->{
					Car car = new Car();
					car.setCarType(carType);
					carRepository.save(car);
				});

				//Place
				Stream.of("Bangkok","Rangsit","Nakornrachasima","Parkchong").forEach(placeName ->{
					Place place = new Place();
					place.setPlaceName(placeName);
					placeRepository.save(place);
				});

				//TransportationCar PK
				
				TransportationCar transportationCar = new TransportationCar();
				transportationCar.setCid(clientRepository.getOne(2L));
				transportationCar.setPlaceId(placeRepository.getOne(2L));
				transportationCar.setCarId(carRepository.getOne(1L));
				transportationCar.setEmpId(employeeRepository.getOne(1L));
				transportationCar.setHouseId(houseRepository.getOne(2L));
				transportationCar.setTransportDetial("ลงใกล้ ๆ กับเซเว่น ตรงข้ามเมเจอร์รังสิตนะครับ");
				transportationCar.setAmountPeople(4);
				transportationCarRepository.save(transportationCar);

				Employee empid =  employeeRepository.findByEmpId(1L);
				House house = houseRepository.findByHouseId(1L);
				RentHouse rent =rentHouseRepository.findByRentId(1L); 
				DeliveryCompany devi = deliveryCompanyRepository.findByDeliComId(1L);
				ManagePackageIn mag = new ManagePackageIn();
				mag.setPackageId("123456789TH");
				mag.setDate(new Date());
				mag.setEmployee(empid);
				mag.setRentHouse(rent);
				mag.setDeliveryCompany(devi);
				mag.setHouse(house);
				mag.setManagePackageOut(null);
				managePackageInRepository.save(mag);

		};
	}
	
}