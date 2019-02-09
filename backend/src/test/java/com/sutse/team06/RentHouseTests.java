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
public class RentHouseTests {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
    public void testSuccess() {
        RentHouse r = new RentHouse();
        r.setResident("Mr.james");

        try {
            entityManager.persist(r);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line testSuccess");
        }
    }

    @Test
    public void testTooShort() {
        RentHouse r = new RentHouse();
        r.setResident("Mr.X");

        try {
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testTooLong() {
        RentHouse r = new RentHouse();
        r.setResident("Ms.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        try {
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    
    @Test
    public void testPattern() {
        RentHouse r = new RentHouse();
        r.setResident("XXX");

        try {
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testNotnull() {
        RentHouse r = new RentHouse();
        r.setResident(null);

        try {
            entityManager.persist(r);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}