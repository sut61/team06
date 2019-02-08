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
public class ManagePackageOutTest {
	
	@Autowired
    private ManagePackageOutRepository managePackageOutTestRepository;

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
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver("user");
        mout.setDate(new Date());
         try {
            entityManager.persist(mout);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
    @Test
    public void testTestInsertReceiverPattern(){
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver("user1");
        mout.setDate(new Date());
         try {
            entityManager.persist(mout);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestTestInsertReceiverPattern #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestInsertReceiverOverSize(){
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver("useruseruseruser");
        mout.setDate(new Date());
         try {
            entityManager.persist(mout);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestTestInsertReceiverOverSize #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
     @Test
    public void testTestInsertReceiverLessSize(){
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver("us");
        mout.setDate(new Date());
         try {
            entityManager.persist(mout);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestTestInsertReceiverLessSize #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testTestInsertReceiverMustNotnull(){
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver(null);
        mout.setDate(new Date());
         try {
            entityManager.persist(mout);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestTestInsertReceiverMustNotnull #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestInsertDateMustNotnull(){
        ManagePackageOut mout = new ManagePackageOut();
        mout.setReceiver("user");
        mout.setDate(null);
         try {
            entityManager.persist(mout);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\ntestTestInsertDateMustNotnull #######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
}