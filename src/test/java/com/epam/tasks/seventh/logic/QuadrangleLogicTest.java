package com.epam.tasks.seventh.logic;

import com.epam.tasks.seventh.QuadrangleParserForTestUse;
import com.epam.tasks.seventh.model.Quadrangle;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class QuadrangleLogicTest {
    private static final String TRAPEZE_LINE = "1 1 2 4 3 4 4 1";
    private static final String SQUARE_LINE = "1 1 1 4 4 4 4 1";
    public static final String THREE_DOTS_ON_ONE_LINE = "1 2 3 2 5 2 7 8";
    private final QuadrangleLogic quadrangleLogic = new QuadrangleLogic();
    private final QuadrangleParserForTestUse parserForTest = new QuadrangleParserForTestUse();
    private final Quadrangle square = parserForTest.getQuadrangle(SQUARE_LINE);
    private final Quadrangle trapeze = parserForTest.getQuadrangle(TRAPEZE_LINE);

    @Test
    public void testCalculateAreaShouldCalculateArea() {
        BigDecimal expected = new BigDecimal("9")
                .setScale(10, RoundingMode.HALF_UP);
        BigDecimal actual = quadrangleLogic.calculateArea(square)
                .setScale(10, RoundingMode.HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculatePerimeterShouldCalculatePerimeter() {
        BigDecimal expected = new BigDecimal("12")
                .setScale(10, RoundingMode.HALF_UP);
        BigDecimal actual = quadrangleLogic.calculatePerimeter(square)
                .setScale(10, RoundingMode.HALF_UP);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsConvexShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleLogic.isConvex(square));
    }

    @Test
    public void testIsSquareShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleLogic.isSquare(square));
    }

    @Test
    public void testIsRhombusShouldReturnTrueForSquare() {
        Assert.assertTrue(quadrangleLogic.isRhombus(square));
    }

    @Test
    public void TestIsTrapezeShouldReturnTrueForTrapeze() {
        Assert.assertTrue(quadrangleLogic.isTrapeze(trapeze));
    }

    @Test
    public void TestIsTrapezeShouldReturnFalseForSquare() {
        Assert.assertFalse(quadrangleLogic.isTrapeze(square));
    }

    @Test
    public void testIsQuadrangleShouldReturnFalsWhenThreeDotsLieOnLine() {
        Quadrangle quadrangle = parserForTest.getQuadrangle(THREE_DOTS_ON_ONE_LINE);

        Assert.assertFalse(quadrangleLogic.isQuadrangle(quadrangle));
    }

    @Test
    public void testIsQuadrangleShouldReturnTrueWhenDotsNotLieOnLine() {
        Quadrangle quadrangle = parserForTest.getQuadrangle(SQUARE_LINE);

        Assert.assertTrue(quadrangleLogic.isQuadrangle(quadrangle));
    }
}