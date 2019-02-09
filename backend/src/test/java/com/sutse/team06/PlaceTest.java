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
public class PlaceTest {

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
    public void testSuccessful() {
       Place place = new Place();
       place.setPlaceName("Hongkong");

        try {
            entityManager.persist(place);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line test Success");
        }
    }

    
    @Test
    public void testPattern() {
        Place place = new Place();
        place.setPlaceName("!#@$#%$#%");
 
         try {
             entityManager.persist(place);
             entityManager.flush();
            fail("Should not pass to this line testPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    @Test
    public void TooShort() {
        Place place = new Place();
        place.setPlaceName("KOK");
 
         try {
             entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line test TooShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testNotnull() {
        Place place = new Place();
        place.setPlaceName(null);
 
         try {
             entityManager.persist(place);
            entityManager.flush();

            fail("Should not pass to this line testNotnull");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

   

    @Test
    public void testUnique() {
        Place place = new Place();
        place.setPlaceName("Phuket");
        
        entityManager.persist(place);
        entityManager.flush();

        Place place1 = new Place();
        place1.setPlaceName("Phuket");
        
        try {
            entityManager.persist(place1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }

   
    

   

}