package com.epam.tasks.seventh.data.validation;

import com.epam.tasks.seventh.data.validation.impl.QuadrangleInputValidator;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleInputValidatorTest {
    private static final String REAL_CORRECT_RECTANGLE = "1 2 3 -4.2 5 6 7.6 8";
    private static final String INTEGER_CORRECT_RECTANGLE = "-1 2 3 -4 5 6 7 -8";
    private static final String NOT_ENOUGH_COORDINATES_RECTANGLE = "1 3 4 5 6 7 8";


    @Test
    public void testIsValidWithCorrectInputRealInput() {
        QuadrangleInputValidator validator = new QuadrangleInputValidator();

        Assert.assertTrue(validator.isValid(REAL_CORRECT_RECTANGLE));
    }

    @Test
    public void testIsValidWithCorrectInputIntegerInput() {
        QuadrangleInputValidator validator = new QuadrangleInputValidator();

        Assert.assertTrue(validator.isValid(INTEGER_CORRECT_RECTANGLE));
    }

    @Test
    public void testIsValidWithNotEnoughCoordinates() {
        QuadrangleInputValidator validator = new QuadrangleInputValidator();

        Assert.assertFalse(validator.isValid(NOT_ENOUGH_COORDINATES_RECTANGLE));
    }
}