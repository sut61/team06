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
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;
import com.sutse.team06.entity.*; 
import com.sutse.team06.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CleanHouseTest {
	
    @Autowired private HouseRepository     houseRepository;
    @Autowired private RentHouseRepository rentHouseRepository;
    @Autowired private CleanHouseRepository cleanHouseRepository;
    @Autowired private HouseKeeperRepository houseKeeperRepository;
    @Autowired private TypeHouseKeeperRepository typeHouseKeeperRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
	
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
	public void testTestInsertDataSuccess() {
            RentHouse renthouses = rentHouseRepository.findByRentId(1L);
            House  house = houseRepository.findByHouseId(1L);
            TypeHouseKeeper keeper = typeHouseKeeperRepository.findByTypehouseKeeperId(1L);
            CleanHouse clean = new CleanHouse();
            clean.setRentHouse(renthouses);
            clean.setHouse(house);
            clean.setTypeHouseKeeper(keeper);
            try {
                    entityManager.persist(clean);
                    entityManager.flush();
            } catch(javax.validation.ConstraintViolationException e) {
                    fail("Should not pass to this line");
            }

    }
    @Test
	public void testTestInsertRentHouseNUll() {
            RentHouse renthouses = rentHouseRepository.findByRentId(10L);
            House  house = houseRepository.findByHouseId(1L);
            TypeHouseKeeper keeper = typeHouseKeeperRepository.findByTypehouseKeeperId(1L);
            CleanHouse clean = new CleanHouse();
            clean.setRentHouse(renthouses);
            clean.setHouse(house);
            clean.setTypeHouseKeeper(keeper);
            try {
                    entityManager.persist(clean);
                    entityManager.flush();
                     fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                    System.out.println("testTestInsertRentHouseNUll#######################################################################");
                    System.out.println(violations);
                    System.out.println("\n");
                    assertEquals(violations.isEmpty(), false);
                    assertEquals(violations.size(), 1);
            }

    }
    @Test
	public void testTestInsertHouseNUll() {
            RentHouse renthouses = rentHouseRepository.findByRentId(1L);
            House  house = houseRepository.findByHouseId(11L);
            TypeHouseKeeper keeper = typeHouseKeeperRepository.findByTypehouseKeeperId(1L);
            CleanHouse clean = new CleanHouse();
            clean.setRentHouse(renthouses);
            clean.setHouse(house);
            clean.setTypeHouseKeeper(keeper);
            try {
                    entityManager.persist(clean);
                    entityManager.flush();
                     fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                    System.out.println("testTestInsertHouseNUll#######################################################################");
                    System.out.println(violations);
                    System.out.println("\n");
                    assertEquals(violations.isEmpty(), false);
                    assertEquals(violations.size(), 1);
            }

    }
    @Test
	public void testTestInsertTypeHouseKeeper() {
            RentHouse renthouses = rentHouseRepository.findByRentId(1L);
            House  house = houseRepository.findByHouseId(1L);
            TypeHouseKeeper keeper = typeHouseKeeperRepository.findByTypehouseKeeperId(11L);
            CleanHouse clean = new CleanHouse();
            clean.setRentHouse(renthouses);
            clean.setHouse(house);
            clean.setTypeHouseKeeper(keeper);
            try {
                    entityManager.persist(clean);
                    entityManager.flush();
                     fail("Should not pass to this line");
            } catch(javax.validation.ConstraintViolationException e) {
                    Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                    System.out.println("testTestInsertHouseNUll#######################################################################");
                    System.out.println(violations);
                    System.out.println("\n");
                    assertEquals(violations.isEmpty(), false);
                    assertEquals(violations.size(), 1);
            }

    }

}