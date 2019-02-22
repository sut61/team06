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
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.*;
import com.sutse.team06.entity.*; 
import com.sutse.team06.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepairsmanTest {
    
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
	
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testTestInsertDataSuccess() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("remanname");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
    @Test
    public void testTestRepairsmanNameNull() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName(null);
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestRepairsmanNameNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestRepairsmanNameSize() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("test");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestRepairsmanNameSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestRepairsmanNamePattern() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("test1234");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestRepairsmanNamePattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTestRepairsmanNameSizeLong() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("testttttttttttttttt");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestRepairsmanNamePattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanNumidNull() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid(null);
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanNumidNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testTestsetRepairsmanNumidSizeLshort() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanNumidSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanNumidSizeLong() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R123456");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanNumidSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanNumidPattern() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("E12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanNumidPattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanEmailNull() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail(null);
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanEmailNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanEmailSize() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("tes@gmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanEmailSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanEmailPattern() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@hotmail.com");
        reman.setRepairsmanTel("0812345678");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanEmailPattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTelNull() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel(null);
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTelNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTelSize() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("08123456789");
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTelSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTelPatten() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0112345678"); // not 01
        reman.setRepairsmanTel2("021234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTelPatten#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTel2Null() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678"); 
        reman.setRepairsmanTel2(null);
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTel2Null#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTel2Size() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678"); 
        reman.setRepairsmanTel2("0212345678");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTel2Size#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestsetRepairsmanTel2Patten() {
        Repairsman reman = new Repairsman();
        reman.setRepairsmanName("usertest");
        reman.setRepairsmanNumid("R12345");
        reman.setRepairsmanEmail("test@gmail.com");
        reman.setRepairsmanTel("0812345678"); 
        reman.setRepairsmanTel2("011234567");
        try {
            entityManager.persist(reman);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n");
            System.out.println("testTestsetRepairsmanTel2Patten#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
}