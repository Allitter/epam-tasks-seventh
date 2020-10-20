package com.epam.tasks.seventh.logic.validation;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.logic.validation.impl.QuadrangleValidator;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleValidatorTest {
    public static final String THREE_DOTS_ON_ONE_LINE = "1 2 3 2 5 2 7 8";
    private static final String SQUARE_LINE = "1 1 1 4 4 4 4 1";

    @Test
    public void testIsQuadrangleShouldReturnFalseWhenThreeDotsLieOnLine() {
        QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parserForTest.getQuadrangle(THREE_DOTS_ON_ONE_LINE);
        QuadrangleValidator validator = new QuadrangleValidator();

        Assert.assertFalse(validator.isValid(quadrangle));
    }

    @Test
    public void testIsQuadrangleShouldReturnTrueWhenDotsNotLieOnLine() {
        QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
        QuadrangleValidator validator = new QuadrangleValidator();
        Quadrangle quadrangle = parserForTest.getQuadrangle(SQUARE_LINE);

        Assert.assertTrue(validator.isValid(quadrangle));
    }
}