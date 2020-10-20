package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.logic.QuadrangleCalculator;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class QuadranglePerimeterRangeSpecificationTest {
    private static final BigDecimal MIN_PERIMETER = BigDecimal.valueOf(9);
    private static final BigDecimal MAX_PERIMETER = BigDecimal.valueOf(9);
    private static final BigDecimal NOT_PROPER_PERIMETER = BigDecimal.valueOf(10);
    private static final String QUADRANGLE_IN_RANGE = "1 1 1 4 4 4 4 1";
    private static final String QUADRANGLE_OUT_OF_RANGE = "1 1 1 8 8 8 8 1";

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadranglePerimeterInRange() {
        // Mock QuadrangleCalculator
        QuadrangleCalculator calculator = Mockito.mock(QuadrangleCalculator.class);
        Mockito.when(calculator.calculatePerimeter(Mockito.any())).thenReturn(MIN_PERIMETER);
        // Crete Quadrangle that matches perimeter range
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_IN_RANGE);
        // Create specification using QuadrangleCalculator mock
        QuadranglePerimeterRangeSpecification specification =
                new QuadranglePerimeterRangeSpecification(
                        MIN_PERIMETER, MAX_PERIMETER, calculator);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrangleNotInRange() {
        // Mock QuadrangleCalculator
        QuadrangleCalculator calculator = Mockito.mock(QuadrangleCalculator.class);
        Mockito.when(calculator.calculatePerimeter(Mockito.any()))
                .thenReturn(NOT_PROPER_PERIMETER);
        // Crete Quadrangle that not matches perimeter range
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_OUT_OF_RANGE);
        // Create specification using QuadrangleCalculator mock
        QuadranglePerimeterRangeSpecification specification =
                new QuadranglePerimeterRangeSpecification(
                        MIN_PERIMETER, MAX_PERIMETER, calculator);

        Assert.assertFalse(specification.specified(quadrangle));
    }

}