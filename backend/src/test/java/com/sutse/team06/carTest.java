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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.persistence.*;

import org.junit.Before;
import org.junit.Test;

import com.sutse.team06.entity.*;
import com.sutse.team06.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class carTest {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
    public void testSuccessful() {
       Car car = new Car();
       car.setCarType("Honda");

        try {
            entityManager.persist(car);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line test Success");
        }
    }

    
    @Test
    public void testPattern() {
        Car car = new Car();
        car.setCarType("##11");

        try {
            entityManager.persist(car);
            entityManager.flush();

            fail("Should not pass to this line testPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    @Test
    public void TooShort() {
        Car car = new Car();
        car.setCarType("H");

        try {
            entityManager.persist(car);
            entityManager.flush();

            fail("Should not pass to this line test TooShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testNotnull() {
        Car car = new Car();
        car.setCarType(null);

        try {
            entityManager.persist(car);
            entityManager.flush();

            fail("Should not pass to this line testNotnull");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   

    @Test
    public void testUnique() {
        Car car = new Car();
        car.setCarType("sport");
        
        entityManager.persist(car);
        entityManager.flush();

        Car car1 = new Car();
        car1.setCarType("sport");
        
        try {
            entityManager.persist(car1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }

   
    

   

}