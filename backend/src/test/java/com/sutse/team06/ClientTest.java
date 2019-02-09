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

import javax.persistence.PersistenceException;
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
public class ClientTest {
	
	@Autowired
    private ClientRepository clientRepository;

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
        Client c1 = new Client();
       c1.setName("aa");
       c1.setPassword("aaaa");
       c1.setUsername("aaaaa");
        try {
            
            entityManager.persist(c1);
            entityManager.flush();

            
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            
        }
    }

    @Test 
   public void testTestTNull() {
    Client c0 = new Client();
    c0.setName(null);
    c0.setPassword("zxcvbn");
    c0.setUsername("aaaaabb");
        try {
            
            entityManager.persist(c0);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n ===============> error data must not be null");
            System.out.println("\n");
            
        }
    }
    
    @Test 
   public void testTestTooLongData() {
    Client c2 = new Client();
    c2.setName("aa");
    c2.setPassword("aaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
    c2.setUsername("aaaaabb");
        try {
            
            entityManager.persist(c2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n ===============> error too long");
            System.out.println("\n");
            
        }
    }
   
    @Test 
   public void testTestTooShortData() {
    Client c3 = new Client();
    c3.setName("aa");
    c3.setPassword("c");
    c3.setUsername("aaaaabb");
        try {
            
            entityManager.persist(c3);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n ===============> error too short data");
            System.out.println("\n");
            
        }
    }

    @Test
    public void testMustBeUnique() {
        Client c4 = new Client();
    c4.setName("aa");
    c4.setPassword("GOKUZAZA");
    c4.setUsername("aaaaabb");
        entityManager.persist(c4);
        entityManager.flush();

        Client c5 = new Client();
        c5.setName("aa");
        c5.setPassword("GOKUZAZA");
        c5.setUsername("aaaaabb");
        try {
                 entityManager.persist(c5);
                 entityManager.flush(); 
                 fail("Should not pass to this line");
        } catch (PersistenceException ex) {
                System.out.println("\n");
                System.out.println("\n\n\n\n\n ===============> error data must be unique");
                System.out.println(ex);
                System.out.println("\n");
                System.out.println("\n");
        }
    }


}