package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleFirstQuadrantSpecificationTest {
    private static final String QUADRANGLE_IN_FIRST_QUADRANT = "1 1 1 4 4 4 4 1";
    private static final String QUADRANGLE_NOT_IN_FIRST_QUADRANT = "-1 -1 -1 -8 -8 -8 -8 -1";

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrangleIsInFirstQuadrant() {
        QuadrangleFirstQuadrantSpecification specification =
                new QuadrangleFirstQuadrantSpecification();
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_IN_FIRST_QUADRANT);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrangleIsNotInFirstQuadrant() {
        QuadrangleFirstQuadrantSpecification specification =
                new QuadrangleFirstQuadrantSpecification();
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE_NOT_IN_FIRST_QUADRANT);

        Assert.assertFalse(specification.specified(quadrangle));
    }
}