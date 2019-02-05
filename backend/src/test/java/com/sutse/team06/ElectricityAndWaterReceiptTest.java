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
public class ElectricityAndWaterReceiptTest {
	
	@Autowired
    private ElectricityAndWaterReceipt electricityandwaterreceiptRepository;

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
        
    }
  /*  @Test 
   public void testTestTooLongData() {
        ElectricityAndWaterReceipt ew = new ElectricityAndWaterReceipt();
        ew.setMeterchecker("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        ew.setSliptid("R22222");
        ew.setWater(200);
        ew.setElectircity(500);
        try {
            
            entityManager.persist(ew);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            
        }
    }
    @Test
    public void testTestTooShortData() {
        ElectricityAndWaterReceipt ew = new ElectricityAndWaterReceipt();
        ew.setMeterchecker("B");
        ew.setSliptid("R33333");
        ew.setWater(200);
        ew.setElectircity(500);
        try {
            entityManager.persist(ew);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestPatternIncorrect() {
        ElectricityAndWaterReceipt ew = new ElectricityAndWaterReceipt();
        ew.setMeterchecker("Dom");
        ew.setSliptid("G44444");
        ew.setWater(200);
        ew.setElectircity(500);
        try {
            
            entityManager.persist(ew);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test(expected=javax.persistence.PersistenceException.class)
    public void testIdMustBeUnique() {
        ElectricityAndWaterReceipt ew1 = new ElectricityAndWaterReceipt();
        ew1.setMeterchecker("Dom");
        ew1.setSliptid("R44444");
        ew1.setWater(200);
        ew1.setElectircity(500);
        entityManager.persist(ew1);
        entityManager.flush();

        ElectricityAndWaterReceipt ew2 = new ElectricityAndWaterReceipt();
        ew1.setMeterchecker("Goku");
        ew1.setSliptid("R44444");
        ew1.setWater(300);
        ew1.setElectircity(400);

        entityManager.persist(ew2);
        entityManager.flush();

        fail("Should not pass to this line");
    }*/


}