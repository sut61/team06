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
public class TypeHouseKeeperTest {
	 
	@Autowired
    private HouseKeeperRepository houseKeeperTestRepository;

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
        TypeHouseKeeper typekeep = new TypeHouseKeeper();
        typekeep.setTypehouseKeeper("Male");
        try {
            entityManager.persist(typekeep);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
      @Test
      public void testInsertsetTypehouseKeeperNull(){
           TypeHouseKeeper typekeep = new TypeHouseKeeper();
            typekeep.setTypehouseKeeper(null);
        try {
            entityManager.persist(typekeep);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("testInsertsetTypehouseKeeperNull#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
      }
      @Test
      public void testInsertsetTypehouseKeeperPattern(){
           TypeHouseKeeper typekeep = new TypeHouseKeeper();
            typekeep.setTypehouseKeeper("Ptaaen");
        try {
            entityManager.persist(typekeep);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("testInsertsetTypehouseKeeperPattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
      }
      @Test
      public void testInsertsetTypehouseKeeperPatternSize(){
           TypeHouseKeeper typekeep = new TypeHouseKeeper();
            typekeep.setTypehouseKeeper("Femalessss");
        try {
            entityManager.persist(typekeep);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("testInsertsetTypehouseKeeperPattern#######################################################################");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
      }
}
