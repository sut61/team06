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
public class RequestInternetTest {
	
	@Autowired
    private RequestInternetRepository requestInternetRepository;

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
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser("name1234");
        reqnet.setNetPassword("pass1234");
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
    @Test
    public void testInsertNetUerNull(){
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser(null);
        reqnet.setNetPassword("pass0000");
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("2.1#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
     }
     @Test
     public void testInsertNetPassNull(){
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser("user1001");
        reqnet.setNetPassword(null);
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("2.1#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
      }
     @Test
     public void testInsertCheckMoreThanSize(){
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser("user567890123456789");
        reqnet.setNetPassword("pass10101");
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("2.2#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
      }
     @Test
     public void testInsertCheckLessThanSize(){
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser("user");
        reqnet.setNetPassword("pass10101");
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("2.3#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
      }
     @Test
     public void testInsertCheckPattern(){
        RequestInternet reqnet = new RequestInternet();
        reqnet.setNetUser("...#####$$");
        reqnet.setNetPassword("pass10101");
        try {
            entityManager.persist(reqnet);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("2.4#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
      }
      
    @Test
    public void testIdMustBeUnique() {
        RequestInternet reqnet1 = new RequestInternet();
        reqnet1.setNetUser("user101010");
        reqnet1.setNetPassword("pass10101");
        entityManager.persist(reqnet1);
        entityManager.flush();

        RequestInternet reqnet2 = new RequestInternet();
        reqnet2.setNetUser("user101010");
        reqnet2.setNetPassword("pass10101");
        try {
                 entityManager.persist(reqnet2);
                 entityManager.flush(); 
                 fail("Should not pass to this line");
        } catch (PersistenceException ex) {
                System.out.println("\n");
                System.out.println("2.5#######################################################################");
                System.out.println(ex);
                System.out.println("\n");
                System.out.println("\n");
        }
    }
}
