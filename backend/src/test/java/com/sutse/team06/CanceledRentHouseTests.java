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
public class CanceledRentHouseTests {

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
        CanceledRentHouse c = new CanceledRentHouse();
        c.setComment("zxvxz");

        try {
            entityManager.persist(c);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line testSuccess");
        }
    }

    
    @Test
    public void testTooShort() {
        CanceledRentHouse c = new CanceledRentHouse();
        c.setComment("");

        try {
            entityManager.persist(c);
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
        CanceledRentHouse c = new CanceledRentHouse();
        c.setComment("$^@%@#^");

        try {
            entityManager.persist(c);
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
        CanceledRentHouse c = new CanceledRentHouse();
        c.setComment(null);

        try {
            entityManager.persist(c);
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
        CanceledRentHouse c = new CanceledRentHouse();
        c.setComment("Alex");
        entityManager.persist(c);
        entityManager.flush();

        CanceledRentHouse c1 = new CanceledRentHouse();
        c1.setComment("Alex");
        try {
            entityManager.persist(c1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }

}