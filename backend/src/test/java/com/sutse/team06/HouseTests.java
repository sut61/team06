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
public class HouseTests {

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
        House h = new House();
        h.setHouseNumber(1234);
        h.setStyle("xxx");

        try {
            entityManager.persist(h);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line testSuccess");
        }
    }

    @Test
    public void testLessThan() {
        House h = new House();
        h.setHouseNumber(999);
        h.setStyle("xxx");

        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTooLong() {
        House h = new House();
        h.setHouseNumber(10000);
        h.setStyle("xxx");

        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test
    public void testNotnull() {
        House h = new House();
        h.setHouseNumber(null);
        h.setStyle("xxx");

        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeStyle() {
        House h = new House();
        h.setHouseNumber(1234); 
        h.setStyle("xxxxxxxxxxxxxxxxxxxxxxxxxx");

        try {
            entityManager.persist(h);
            entityManager.flush();
            fail("Should not pass to this line testSuccess");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testUnique() {
        House h = new House();
        h.setHouseNumber(5555);
        h.setStyle("xxx");
        entityManager.persist(h);
        entityManager.flush();

        House h1 = new House();
        h1.setHouseNumber(5555);
        h1.setStyle("xxx");
        try {
            entityManager.persist(h1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }
}