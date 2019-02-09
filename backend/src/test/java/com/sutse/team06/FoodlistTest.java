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
public class FoodlistTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private FoodListRepository foodListRepository;
    private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
	public void DataSuccess() {
        FoodList food = new FoodList();
        food.setFoodlistName("Bread");
        food.setFoodlistPrice(20);
        try {
            
            entityManager.persist(food);
            entityManager.flush();

            
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            
        }
    }

    @Test
    public void testPattern() {
        FoodList food = new FoodList();
        food.setFoodlistName("11111111");
        food.setFoodlistPrice(40);

        try {
            entityManager.persist(food);
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
        FoodList food = new FoodList();
        food.setFoodlistName("B");
        food.setFoodlistPrice(20);

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line testTooShort");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNotnullFoodlistName() {
        FoodList food = new FoodList();
        food.setFoodlistName(null);
        food.setFoodlistPrice(20);

        try {
            entityManager.persist(food);
            entityManager.flush();

            fail("Should not pass to this line testPattern");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testNotnullFoodlistPrice() {
        FoodList food = new FoodList();
        food.setFoodlistName("Sanwish");
        food.setFoodlistPrice(null);

        try {
            entityManager.persist(food);
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
        FoodList food = new FoodList();
        food.setFoodlistName("porkball");
        food.setFoodlistPrice(20);
        
        entityManager.persist(food);
        entityManager.flush();

        FoodList food1 = new FoodList();
        food1.setFoodlistName("porkball");
        food1.setFoodlistPrice(20);
        
        try {
            entityManager.persist(food1);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println(ex);
        }

    }

   
    

   

}