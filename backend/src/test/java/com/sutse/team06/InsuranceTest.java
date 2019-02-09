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
public class InsuranceTest {
	
	@Autowired
    private InsuranceRepository insuranceRepository;

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
        Insurance insu = new Insurance();
        insu.setInsuname("best");
        insu.setEmail("best@hotmail.com");
        try {
            
            entityManager.persist(insu);
            entityManager.flush();

            
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            
        }
    }

    @Test 
    public void testTestTooLongData() {
        Insurance insu1 = new Insurance();
        insu1.setInsuname("GOKUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        insu1.setEmail("goku@hotmail.com");
         try {
             
             entityManager.persist(insu1);
             entityManager.flush();
 
             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 2);
             System.out.println("\n\n\n\n\n ===============> error too long");
             System.out.println("\n");
             
         }
     }

     @Test
     public void testTestTooShortData() {
        Insurance insu2 = new Insurance();
        insu2.setInsuname("V");
        insu2.setEmail("v@hotmail.com");
         try {
             entityManager.persist(insu2);
             entityManager.flush();
 
             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 2);
             System.out.println("\n\n\n\n\n ===============> error too short");
             System.out.println("\n");
         }
     }

     @Test
    public void testTestPatternIncorrect() {
        Insurance insu3 = new Insurance();
        insu3.setInsuname("asf561165");
        insu3.setEmail("as@fhotmail.com");
        try {
            
            entityManager.persist(insu3);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("\n\n\n\n\n ===============> error patern incorrect");
            System.out.println("\n");
        }
    }
     
    @Test
    public void testMustBeUnique() {
        Insurance insu4 = new Insurance();
        insu4.setInsuname("Vegeta");
        insu4.setEmail("vegeta@fhotmail.com");
        entityManager.persist(insu4);
        entityManager.flush();

        ElectricityAndWaterReceipt ew4 = new ElectricityAndWaterReceipt();
        Insurance insu5 = new Insurance();
        insu5.setInsuname("Bluma");
        insu5.setEmail("vegeta@fhotmail.com");
        entityManager.persist(insu4);
        try {
                 entityManager.persist(insu5);
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

    @Test
    public void testTestNotnull() {
        Insurance insu6 = new Insurance();
        insu6.setInsuname(null);
        insu6.setEmail("null@hotmail.com");
        try {
            
            entityManager.persist(insu6);
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

}
    