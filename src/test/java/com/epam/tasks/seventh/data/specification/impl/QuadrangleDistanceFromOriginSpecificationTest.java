package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.logic.VectorCalculator;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;

public class QuadrangleDistanceFromOriginSpecificationTest {
    private static final BigDecimal SIX = BigDecimal.valueOf(6);
    private static final String QUADRANGLE_CLOSER_THAN_DISTANCE = "1 1 1 4 4 4 4 1";
    private static final String QUADRANGLE_FARTHER_THAN_DISTANCE = "1 1 1 8 8 8 8 1";

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrangleCloserOrEqualsToDistance() {
        // Mock VectorCalculator
        VectorCalculator calculator = Mockito.mock(VectorCalculator.class);
        Mockito.when(calculator.countDistanceFromOrigin(Mockito.any())).thenReturn(SIX);
        // Create specification with VectorCalculator mock
        QuadrangleDistanceFromOriginSpecification specification
                = new QuadrangleDistanceFromOriginSpecification(SIX);
        // Create quadrangle with area that matches
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_CLOSER_THAN_DISTANCE);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrangleFartherThanDistance() {
        // Mock VectorCalculator
        VectorCalculator calculator = Mockito.mock(VectorCalculator.class);
        Mockito.when(calculator.countDistanceFromOrigin(Mockito.any()))
                .thenReturn(BigDecimal.TEN);
        // Create specification with VectorCalculator mock
        QuadrangleDistanceFromOriginSpecification specification
                = new QuadrangleDistanceFromOriginSpecification(SIX, calculator);
        // Create quadrangle with area that not matches
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_FARTHER_THAN_DISTANCE);

        Assert.assertFalse(specification.specified(quadrangle));
    }
}