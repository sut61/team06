package com.sutse.team06;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.tomcat.jni.Mmap;
import org.junit.Before;
import org.junit.Test;

import com.sutse.team06.entity.*;
import com.sutse.team06.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ManagePackageInTest {
	
	@Autowired
    private ManagePackageInRepository managePackageInRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    @Autowired 
    private HouseRepository houseRepository;
    @Autowired 
    private RentHouseRepository rentHouseRepository;
    @Autowired 
    private DeliveryCompanyRepository deliveryCompanyRepository;

    @Autowired
    private TestEntityManager entityManager;
   
    private Validator validator;
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
         
        
    }
    //ทดสอบ save data ปกติ
    @Test
	public void testTestInsertDataSuccess() {
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("1234567890TH");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            System.out.println("Manage pacakate in#########################################"+e);
            fail("Should not pass to this line");
        }
    }
    //ทดสอบ ความยาวไม่ถึง
    @Test
	public void testTestPackageIdSizeLessThan8() {
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("1234TH");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //คาดการว่าจะเกิด error เท้าไร
            assertEquals(violations.size(), 2);
        }
    }
    // // ทดสอบห้ามเป็น not null
    @Test
	public void testTestPackageIdNotNull() {
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId(null);
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    // // ทดสอบ pattern ไม่ตรง
    @Test
	public void testTestPackageIdDonthaveTH() {
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
	public void testTestDateNotnull() {
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789TH");
        mag.setDate(null);
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testEmployeeIdnotnull(){
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789TH");
        mag.setDate(new Date());
        mag.setEmployee(null);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        
    }
    @Test
    public void testHouseIdnotnull(){
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789TH");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(devi);
        mag.setHouse(null);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        
    }
    @Test
    public void testRentHousIdnotnull(){
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789TH");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(null);
        mag.setDeliveryCompany(devi);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        
    }
    @Test
    public void tesDeliveryCompanyIdnotnull(){
        Employee emp =  this.employeeRepository.findByEmpId(1L);
        House house = this.houseRepository.findByHouseId(1L);
        RentHouse rent = this.rentHouseRepository.findByRentId(1L); 
        DeliveryCompany devi = this.deliveryCompanyRepository.findByDeliComId(1L);
        ManagePackageIn mag = new ManagePackageIn();
        mag.setPackageId("123456789TH");
        mag.setDate(new Date());
        mag.setEmployee(emp);
        mag.setRentHouse(rent);
        mag.setDeliveryCompany(null);
        mag.setHouse(house);
        mag.setManagePackageOut(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
        
    }
    

    

	

}
