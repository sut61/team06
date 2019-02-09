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
public class CancelTypeTests {

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
        CancelType ct = new CancelType();
        ct.setCanceltype("abcd");

        try {
            entityManager.persist(ct);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line testSuccess");
        }
    }

    @Test
    public void testTooShort() {
        CancelType ct = new CancelType();
        ct.setCanceltype("XXX");

        try {
            entityManager.persist(ct);
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
        CancelType ct = new CancelType();
        ct.setCanceltype("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        try {
            entityManager.persist(ct);
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
        CancelType ct = new CancelType();
        ct.setCanceltype(null);

        try {
            entityManager.persist(ct);
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
        CancelType ct = new CancelType();
        ct.setCanceltype("WXYZ");
        entityManager.persist(ct);
        entityManager.flush();

        CancelType ct1 = new CancelType();
        ct1.setCanceltype("WXYZ");
        try {
            entityManager.persist(ct1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }
}