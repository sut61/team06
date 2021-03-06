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
public class ElectricityAndWaterReceiptTest {
	
	@Autowired
    private ElectricityAndWaterReceiptRepository electricityandwaterreceiptRepository;

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
        ElectricityAndWaterReceipt ewr = new ElectricityAndWaterReceipt();
        ewr.setMeterchecker("june");
        ewr.setSliptid("R12345");
        ewr.setWater(200);
        ewr.setElectricity(500);
        try {
            
            entityManager.persist(ewr);
            entityManager.flush();

            
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            
        }
    }
    
    @Test 
   public void testTestTooLongData() {
        ElectricityAndWaterReceipt ew = new ElectricityAndWaterReceipt();
        ew.setMeterchecker("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        ew.setSliptid("R22222");
        ew.setWater(200);
        ew.setElectricity(500);
        try {
            
            entityManager.persist(ew);
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
        ElectricityAndWaterReceipt ew1 = new ElectricityAndWaterReceipt();
        ew1.setMeterchecker("B");
        ew1.setSliptid("R33333");
        ew1.setWater(200);
        ew1.setElectricity(500);
        try {
            entityManager.persist(ew1);
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
        ElectricityAndWaterReceipt ew2 = new ElectricityAndWaterReceipt();
        ew2.setMeterchecker("Dom");
        ew2.setSliptid("G44444");
        ew2.setWater(200);
        ew2.setElectricity(500);
        try {
            
            entityManager.persist(ew2);
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
        ElectricityAndWaterReceipt ew3 = new ElectricityAndWaterReceipt();
        ew3.setSliptid("R44444");
        ew3.setMeterchecker("aaaa");
        ew3.setWater(200);
        ew3.setElectricity(500);
        entityManager.persist(ew3);
        entityManager.flush();

        ElectricityAndWaterReceipt ew4 = new ElectricityAndWaterReceipt();
        ew4.setSliptid("R44444");
        ew4.setMeterchecker("bbb");
        ew4.setWater(200);
        ew4.setElectricity(500);
        try {
                 entityManager.persist(ew4);
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
        ElectricityAndWaterReceipt ew4 = new ElectricityAndWaterReceipt();
        ew4.setMeterchecker(null);
        ew4.setSliptid("R65478");
        ew4.setWater(200);
        ew4.setElectricity(500);
        try {
            
            entityManager.persist(ew4);
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