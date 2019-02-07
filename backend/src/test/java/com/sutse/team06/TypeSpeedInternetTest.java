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
public class TypeSpeedInternetTest {
	
	@Autowired
    private TypeSpeedInternetRepository typeSpeedInternetRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
	
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testTestInsertDataSuccess(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("10/10 Mb");
        typespeed.setConnection(10);
         try {
            entityManager.persist(typespeed);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
     @Test
     public void testSetTypeSpeedUerNull(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed(null);
        typespeed.setConnection(10);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetTypeSpeedUerNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testSetTypeSpeedPattern(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("10/10 MM");
        typespeed.setConnection(10);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetTypeSpeedPattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testSetTypeSpeedOverSize(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("1000/10000 Mb");
        typespeed.setConnection(10);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetTypeSpeedOverSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testSetConnectionNotNull(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("10/10 Mb");
        typespeed.setConnection(null);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetConnectionNotNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testSetConnectionOverSize(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("10/10 Mb");
        typespeed.setConnection(30);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetConnectionOverSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testSetConnectionLessSize(){
        TypeSpeedInternet typespeed = new TypeSpeedInternet();
        typespeed.setTypeSpeed("10/10 Mb");
        typespeed.setConnection(-1);
        try {
            entityManager.persist(typespeed);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestSetConnectionLessSize#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
}