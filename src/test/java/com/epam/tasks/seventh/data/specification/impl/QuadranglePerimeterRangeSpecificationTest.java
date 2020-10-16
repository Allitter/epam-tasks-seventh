package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.ObservableQuadrangle;
import com.epam.tasks.seventh.model.Quadrangle;
import com.epam.tasks.seventh.model.QuadrangleConstructorParameter;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class QuadranglePerimeterRangeSpecificationTest {
    private static final BigDecimal MIN_PERIMETER = BigDecimal.valueOf(9);
    private static final BigDecimal MAX_PERIMETER = BigDecimal.valueOf(9);
    private static final String QUADRANGLE_IN_RANGE = "1 1 1 4 4 4 4 1";
    private static final String QUADRANGLE_OUT_OF_RANGE = "1 1 1 8 8 8 8 1";

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadranglePerimeterInRange() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_IN_RANGE);
        QuadranglePerimeterRangeSpecification specification =
                new QuadranglePerimeterRangeSpecification(
                        MIN_PERIMETER, MAX_PERIMETER);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrangleNotInRange() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_OUT_OF_RANGE);
        QuadranglePerimeterRangeSpecification specification =
                new QuadranglePerimeterRangeSpecification(
                        MIN_PERIMETER, MAX_PERIMETER);

        Assert.assertFalse(specification.specified(quadrangle));
    }

}