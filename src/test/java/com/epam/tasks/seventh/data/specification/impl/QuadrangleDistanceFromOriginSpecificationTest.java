package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class QuadrangleDistanceFromOriginSpecificationTest {

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrangleCloserOrEqualsToDistance() {
        QuadrangleDistanceFromOriginSpecification specification
                = new QuadrangleDistanceFromOriginSpecification(BigDecimal.valueOf(6));
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle("1 1 1 4 4 4 4 1");

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrangleFartherThanDistance() {
        QuadrangleDistanceFromOriginSpecification specification
                = new QuadrangleDistanceFromOriginSpecification(BigDecimal.valueOf(6));
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle("1 1 1 8 8 8 8 1");

        Assert.assertFalse(specification.specified(quadrangle));
    }
}