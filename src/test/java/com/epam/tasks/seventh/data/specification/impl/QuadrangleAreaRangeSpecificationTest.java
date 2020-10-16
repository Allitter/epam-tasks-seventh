package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class QuadrangleAreaRangeSpecificationTest {
    private static final String QUADRANGLE_IN_RANGE = "1 1 1 4 4 4 4 1";
    private static final String QUADRANGLE_OUT_OF_RANGE = "1 1 1 8 8 8 8 1";
    private static final BigDecimal MIN_AREA = BigDecimal.valueOf(1);
    private static final BigDecimal MAX_AREA = BigDecimal.valueOf(10);

    @Test
    public void testSpecifiedShouldReturnTrueWhenAreaIsInRange() {
        QuadrangleAreaRangeSpecification specification
                = new QuadrangleAreaRangeSpecification(MIN_AREA, MAX_AREA);
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_IN_RANGE);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenAreaIsNotInRange() {
        QuadrangleAreaRangeSpecification specification
                = new QuadrangleAreaRangeSpecification(MIN_AREA, MAX_AREA);
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_OUT_OF_RANGE);

        Assert.assertFalse(specification.specified(quadrangle));
    }
}