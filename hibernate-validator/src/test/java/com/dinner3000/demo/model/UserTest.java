package com.dinner3000.demo.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

public class UserTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void AddTest() {
        User user = new User();
        user.setName("1234567890");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        Iterator<ConstraintViolation<User>> iter = violations.iterator();
        if (iter.hasNext()) {
            String errMessage = iter.next().getMessage();
            throw new ValidationException(errMessage);
        }
    }
}