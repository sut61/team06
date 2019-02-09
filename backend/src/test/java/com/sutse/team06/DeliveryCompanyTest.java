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

import org.junit.Before;
import org.junit.Test;

import com.sutse.team06.entity.*;
import com.sutse.team06.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeliveryCompanyTest {
	
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
    @Test
	public void testTestInsertDataSuccess(){
        DeliveryCompany com = new DeliveryCompany();
        com.setName("thai post");
        try {
            entityManager.persist(com);
            entityManager.flush();
        }  catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
    @Test
    public void testSetNamePattern() {  
         DeliveryCompany com = new DeliveryCompany();
         com.setName("thai007");
         try {
            entityManager.persist(com);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetNamePattern #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
         
    }
    @Test
    public void testSetNameOverSize() {  
         DeliveryCompany com = new DeliveryCompany();
         com.setName("thai postttttttttttttttttttt");
         try {
            entityManager.persist(com);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetNameOverSize #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
         
    }
    @Test
     public void testSetNameLessSize() {  
         DeliveryCompany com = new DeliveryCompany();
         com.setName("ei");
         try {
            entityManager.persist(com);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetNameLessSize #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
         
    }
    @Test
    public void testSetNameMustNotNull() {  
         DeliveryCompany com = new DeliveryCompany();
         com.setName(null);
         try {
            entityManager.persist(com);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetNameLessSize #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }  
    }
}