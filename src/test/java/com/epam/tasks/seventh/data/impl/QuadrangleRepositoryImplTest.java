package com.epam.tasks.seventh.data.impl;

import com.epam.tasks.seventh.data.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.data.exception.DataException;
import com.epam.tasks.seventh.data.specification.Specification;
import com.epam.tasks.seventh.model.Point;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

public class QuadrangleRepositoryImplTest {
    private static final String QUADRANGLE = "1 1 1 4 4 4 4 1";

    @Test
    public void testAddShouldAddQuadrangleToRepositoryIfNotContainsSuch() throws DataException {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = new ArrayList<>();
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);

        repository.add(quadrangle);

        Assert.assertTrue(quadrangles.contains(quadrangle));
    }

    @Test(expected = DataException.class)
    public void testAddShouldThrowExceptionIfContainsAddedQuadrangle() throws DataException {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = Collections.singletonList(quadrangle);
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);

        repository.add(quadrangle);
    }

    @Test
    public void testRemoveShouldRemoveQuadrangleFromRepositoryIfContainsSuch() throws DataException {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = new ArrayList<>();
        quadrangles.add(quadrangle);
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);

        repository.remove(quadrangle);

        Assert.assertFalse(quadrangles.contains(quadrangle));
    }

    @Test(expected = DataException.class)
    public void testRemoveShouldThrowExceptionIfNotContainsSuchQuadrangle() throws DataException {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle quadrangle = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = new ArrayList<>();
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);

        repository.remove(quadrangle);
    }

    @Test
    public void testUpdateShouldUpdateQuadrangleIfContainsSuch() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle expected = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = new ArrayList<>();
        quadrangles.add(expected);
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);
        Point point = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
        expected.setPointA(point);
        repository.update(expected);

        Quadrangle actual = quadrangles.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQueryShouldReturnListOfSpecifiedQuadrangles() {
        QuadrangleParserForTestUse parser = new QuadrangleParserForTestUse();
        Quadrangle firstQuadrangle = parser.getQuadrangle(QUADRANGLE);
        Quadrangle secondQuadrangle = parser.getQuadrangle(QUADRANGLE);
        List<Quadrangle> quadrangles = Arrays.asList(firstQuadrangle, secondQuadrangle);
        QuadrangleRepositoryImpl repository = new QuadrangleRepositoryImpl(quadrangles);
        Specification specification = Mockito.mock(Specification.class);
        Mockito.when(specification.specified(Mockito.any())).thenReturn(true);

        List<Quadrangle> actual = repository.query(specification);

        Assert.assertEquals(quadrangles, actual);
    }
}