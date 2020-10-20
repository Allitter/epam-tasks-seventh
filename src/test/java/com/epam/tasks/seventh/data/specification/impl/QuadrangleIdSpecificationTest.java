package com.epam.tasks.seventh.data.specification.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleIdSpecificationTest {
    private static final String QUADRANGLE = "1 1 1 4 4 4 4 1";

    @Test
    public void testSpecifiedShouldReturnTrueWhenQuadrangleIdMatches() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        int id = quadrangle.getId();
        QuadrangleIdSpecification specification = new QuadrangleIdSpecification(id);

        Assert.assertTrue(specification.specified(quadrangle));
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenQuadrangleNotMatches() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        int id = quadrangle.getId();
        QuadrangleIdSpecification specification = new QuadrangleIdSpecification(id + 1);

        Assert.assertFalse(specification.specified(quadrangle));
    }

}