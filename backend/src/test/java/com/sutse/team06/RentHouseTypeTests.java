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
public class RentHouseTypeTests {

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
        RentHouseType rt = new RentHouseType();
        rt.setDescription("5 days");

        try {
            entityManager.persist(rt);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line testSuccess");
        }
    }

    @Test
    public void testTooShort() {
        RentHouseType rt = new RentHouseType();
        rt.setDescription("7 d");

        try {
            entityManager.persist(rt);
            entityManager.flush();

            fail("Should not pass to this line testTooShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testTooLong() {
        RentHouseType rt = new RentHouseType();
        rt.setDescription("123 monthssss");

        try {
            entityManager.persist(rt);
            entityManager.flush();

            fail("Should not pass to this line testTooShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPattern() {
        RentHouseType rt = new RentHouseType();
        rt.setDescription("2 years");

        try {
            entityManager.persist(rt);
            entityManager.flush();

            fail("Should not pass to this line testPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNotnull() {
        RentHouseType rt = new RentHouseType();
        rt.setDescription(null);

        try {
            entityManager.persist(rt);
            entityManager.flush();

            fail("Should not pass to this line testPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testUnique() {
        RentHouseType rt = new RentHouseType();
        rt.setDescription("7 days");
        entityManager.persist(rt);
        entityManager.flush();

        RentHouseType rt1 = new RentHouseType();
        rt1.setDescription("7 days");
        try {
            entityManager.persist(rt1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }

}